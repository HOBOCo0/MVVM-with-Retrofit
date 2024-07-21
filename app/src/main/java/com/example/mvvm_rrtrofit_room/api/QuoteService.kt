package com.example.mvvm_rrtrofit_room.api

import com.example.mvvm_rrtrofit_room.models.QuoteList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteService {
    @GET("/quotes")
    suspend fun getQuote(@Query("limit") limit: Int, @Query("skip") skip:Int): Response<QuoteList>
}