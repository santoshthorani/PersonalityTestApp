package com.example.presentation_layer.ui

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.CompoundButton
import androidx.appcompat.app.AppCompatDelegate
import com.example.presentation_layer.R
import com.example.presentation_layer.databinding.ActivityMainBinding
import com.example.presentation_layer.ui.test.TestActivity
import com.example.presentation_layer.utils.Util
import com.example.presentation_layer.utils.viewbinding.viewBinding
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnStartTest.setOnClickListener {
            startActivity<TestActivity>()
            finish()
        }
        binding.switchNightMode.isChecked = Util.isNightMode(this)
        binding.switchNightMode.setOnCheckedChangeListener { buttonView, isChecked ->
         Log.e("switch", isChecked.toString())
            Util.changeMode(isChecked)
        }
    }
}