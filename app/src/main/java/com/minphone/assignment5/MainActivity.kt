package com.minphone.assignment5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.LinearLayoutManager
import com.minphone.assignment5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

      private lateinit var binding: ActivityMainBinding

      override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)

            val products = listOf(
                  Product(
                        R.drawable.ipad,
                        "iPad",
                        "iPad Pro 11-inch",
                        400.0
                  ),
                  Product(
                        R.drawable.macbookm3,
                        "MacBook M3 Pro",
                        "12-core CPU\n18-core GPU",
                        2500.00
                  ),
                  Product(
                        R.drawable.dell,
                        "Dell Inspiron",
                        "13th Gen Intel® Core™ i7",
                        1499.00
                  ),
                  Product(
                        R.drawable.logitech,
                        "Logitech Keyboard",
                        "Logitech - PRO X TKL LIGHTSPEED Wireless",
                        199.00
                  ),
                  Product(
                        R.drawable.macbookmax,
                        "MacBook M3 Max",
                        "14-core CPU\n30-core GPU",
                        3499.00
                  )
            )

            val adapter = ProductRecyclerView(products, object : ClickListener {
                  override fun setOnViewHolderClickListener(product: Product) {
                        startActivity(ProductDetailActivity.newInstance(this@MainActivity, product))
                  }
            })

            binding.rvProduct.adapter = adapter
            binding.btnViewCart.setOnClickListener {

            }
      }
}