package com.example.presentation_layer.ui.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.example.domain_layer.model.Question
import com.example.domain_layer.model.state.Resource
import com.example.presentation_layer.databinding.ActivityTestBinding
import com.example.presentation_layer.ui.ResultActivity
import com.example.presentation_layer.ui.test.adapter.ViewPagerAdapter
import com.example.presentation_layer.utils.observe
import com.example.presentation_layer.utils.viewbinding.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

@AndroidEntryPoint
class TestActivity : AppCompatActivity(), ViewPagerAdapter.AnswerItemClickListener {

    private val binding by viewBinding(ActivityTestBinding::inflate)
    private val viewModel: TestViewModel by viewModels()
    private var questions = emptyList<Question>()
  private  var answers :Int =0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        observe(viewModel.uiState(), ::handleQuestionsList)
        viewModel.getQuestions()
    }

    private fun handleQuestionsList(resource: Resource<List<Question>>) {
        when (resource) {
            is Resource.Loading -> {

            }
            is Resource.Success -> resource.data?.let {
                questions = it
                initViews(it)
            }
            is Resource.DataError -> {
                toast(resource.e.message.toString())
            }
        }
    }

    private fun initViews(list: List<Question>) {
        binding.viewPager2.apply {
            isUserInputEnabled = false
            adapter = ViewPagerAdapter(list, this@TestActivity)
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
        }
    }

    override fun onItemClick(_position: Int, selectedAnswer: Int) {
        _position.let {
            answers+=selectedAnswer+1
            questions[it]._selectedAnswer = selectedAnswer
            if (it == questions.size - 1) {
                startActivity<ResultActivity>(
                    "result" to answers
                )
                finish()
            } else {
                binding.viewPager2.currentItem = it + 1
            }
        }
    }

}