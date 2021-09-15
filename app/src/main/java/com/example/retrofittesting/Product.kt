package com.example.retrofittesting

data class Product(
    val category: String,
    val description: String,
    val id: Int?=null,
    val image: String,
    val price: Double,
    val title: String
)