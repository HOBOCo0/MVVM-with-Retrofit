package com.example.mvvm_rrtrofit_room.roomDB

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.mvvm_rrtrofit_room.models.Quote

@Dao
interface QuoteDao {
    @Insert
    suspend fun addQuotes(quotes:List<Quote>)
    @Query("SELECT * FROM quote")
    suspend fun getQuotes(): List<Quote>
}