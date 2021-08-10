package com.example.wownation

data class Store(
    val id:Int,
    val Image: Int,
    val Title: String,
    val price: Int,
    val progress:Int = 0
)
