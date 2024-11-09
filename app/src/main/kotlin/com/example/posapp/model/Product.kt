package com.example.posapp.model

data class Product(
    val id: Int? = null,
    val name: String,
    val price: Double,
    var stock: Int
)