package com.example.presentation_layer.ui.test.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.domain_layer.model.Question
import com.example.presentation_layer.databinding.QuestionItemBinding

class ViewPagerAdapter(
    private val dataValue: List<Question>,
    private val answerClickListener: AnswerItemClickListener
) : RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder>() {

    inner class ViewPagerViewHolder(private var binding: QuestionItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            val question = dataValue[position]
            if (position == dataValue.size - 1) {
                binding.nextQuestionBtn.text = "Finish Test"
            } else {
                binding.nextQuestionBtn.text = "Next Question"
            }
            val answerAdapter = AnswerAdapter {
                binding.nextQuestionBtn.isEnabled = true
            }.apply {
                items = question._answers!!
            }
            binding.questionTv.text = question._question
            binding.answersRv.apply {
                adapter = answerAdapter
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            }
            binding.nextQuestionBtn.setOnClickListener {
                answerClickListener.onItemClick(position, answerAdapter.selectedPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder =
        ViewPagerViewHolder(
            QuestionItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )


    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = dataValue.size

    interface AnswerItemClickListener {
        fun onItemClick(_position: Int, selectedAnswer: Int)
    }
}