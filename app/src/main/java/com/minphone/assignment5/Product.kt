package com.minphone.assignment5

import java.io.Serializable

data class Product(
      val productImage: Int,
      val productName: String,
      val productDescription: String,
      val cost: Double
) : Serializable