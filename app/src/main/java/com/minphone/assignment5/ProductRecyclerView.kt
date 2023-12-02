package com.minphone.assignment5

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import com.minphone.assignment5.databinding.ViewholderProductBinding

class ProductRecyclerView(
      private val products: List<Product>,
      private val listener: ClickListener
) :
      RecyclerView.Adapter<ProductRecyclerView.ViewHolder>() {

      class ViewHolder(private val binding: ViewholderProductBinding, listener: ClickListener) :
            RecyclerView.ViewHolder(binding.root) {

            private lateinit var product: Product

            init {
                  binding.root.setOnClickListener {
                        listener.setOnViewHolderClickListener(product)
                  }

                  binding.btnAdd.setOnClickListener {
                        listener.setOnAddClickListener(product)
                  }
            }

            fun bind(product: Product) {
                  this.product = product
                  binding.ivProduct.setImageDrawable(
                        AppCompatResources.getDrawable(
                              binding.root.context,
                              product.productImage
                        )
                  )
                  binding.tvProductName.text = product.productName
                  binding.tvProductDesc.text = product.productDescription
                  binding.tvProductPrice.text = "$ ${product.cost}"
            }
      }

      override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val binding = ViewholderProductBinding.inflate(
                  LayoutInflater.from(parent.context),
                  parent,
                  false
            )
            return ViewHolder(binding, listener)
      }

      override fun getItemCount(): Int = products.size

      override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(products[position])
      }

}

interface ClickListener {
      fun setOnViewHolderClickListener(product: Product)
      fun setOnAddClickListener(product: Product)
}