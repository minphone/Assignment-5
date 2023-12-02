package com.minphone.assignment5

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import com.minphone.assignment5.databinding.ActivityCartBinding
import com.minphone.assignment5.databinding.ActivityProductDetailBinding

class ProductDetailActivity : AppCompatActivity() {

      private lateinit var binding: ActivityProductDetailBinding

      companion object {
            fun newInstance(context: Context, product: Product): Intent {
                  val intent = Intent(context, ProductDetailActivity::class.java)
                  intent.putExtra("product", product)
                  return intent
            }
      }

      override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            val product = intent.getSerializableExtra("product", Product::class.java)
            binding = ActivityProductDetailBinding.inflate(layoutInflater)
            setContentView(binding.root)

            binding.ivProduct.setImageDrawable(AppCompatResources.getDrawable(this, product!!.productImage))
            binding.tvProductName.text = product.productName
            binding.tvProductDesc.text = product.productDescription
            binding.tvProductPrice.text = product.cost.toString()

            binding.btnHome.setOnClickListener { onBackPressed() }
      }
}
