package com.example.posapp.model

import java.time.LocalDateTime

data class Sale(
    val id: Int? = null,
    val items: List<SaleItem>,
    val total: Double,
    val timestamp: LocalDateTime = LocalDateTime.now()
)

data class SaleItem(
    val product: Product,
    val quantity: Int,
    val price: Double
)