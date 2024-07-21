package com.example.mvvm_rrtrofit_room.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("quote")
data class Quote(
    @PrimaryKey(autoGenerate = true)
    val quoteId: Int,
    val author: String,
    val id: Int,
    val quote: String
)