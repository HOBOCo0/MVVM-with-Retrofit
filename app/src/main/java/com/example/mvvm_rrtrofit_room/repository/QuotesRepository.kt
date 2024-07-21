package com.example.mvvm_rrtrofit_room.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvm_rrtrofit_room.api.QuoteService
import com.example.mvvm_rrtrofit_room.models.QuoteList

class QuotesRepository(private val quoteService:QuoteService) {

    private val quoteLiveData = MutableLiveData<QuoteList>()

    val quotes : LiveData<QuoteList>
        get() = quoteLiveData
    suspend fun getQuotes(limit: Int, skip:Int ){
        val result = quoteService.getQuote(limit,skip)
        if (result?.body() != null){
            quoteLiveData.postValue(result.body())
        }
    }
}