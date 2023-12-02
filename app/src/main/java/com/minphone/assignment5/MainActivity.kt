package com.minphone.assignment5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.minphone.assignment5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

      private lateinit var binding: ActivityMainBinding

      override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)

            binding.btnQuiz.setOnClickListener {
                  startActivity(QuizActivity.newInstance(this))
            }
      }
}