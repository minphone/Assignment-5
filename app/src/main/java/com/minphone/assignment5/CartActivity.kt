package com.minphone.assignment5

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.minphone.assignment5.databinding.ActivityCartBinding

class CartActivity : AppCompatActivity() {

      private lateinit var binding: ActivityCartBinding

      companion object {
            fun newInstance(context: Context): Intent {
                  return Intent(context, CartActivity::class.java)
            }
      }

      override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

      }
}
