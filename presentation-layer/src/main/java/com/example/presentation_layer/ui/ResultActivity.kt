package com.example.presentation_layer.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.presentation_layer.R
import com.example.presentation_layer.databinding.ActivityResultBinding
import com.example.presentation_layer.utils.Util
import com.example.presentation_layer.utils.viewbinding.viewBinding

class ResultActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityResultBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val result: Int = intent.getIntExtra("result", 0)

        setContentView(binding.root)
        binding.tvResult.text =getString(R.string.result, Util.getFinalResult(result))


    }

}