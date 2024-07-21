package com.example.mvvm_rrtrofit_room.models

data class QuoteList(
    val limit: Int,
    val quotes: List<Quote>,
    val skip: Int,
    val total: Int
)