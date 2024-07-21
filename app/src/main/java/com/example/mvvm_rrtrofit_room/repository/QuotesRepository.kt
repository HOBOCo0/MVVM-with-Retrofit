package com.example.mvvm_rrtrofit_room.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvm_rrtrofit_room.api.QuoteService
import com.example.mvvm_rrtrofit_room.models.QuoteList
import com.example.mvvm_rrtrofit_room.roomDB.QuoteDatabase
import com.example.mvvm_rrtrofit_room.utils.NetworkUtils

class QuotesRepository(
    private val quoteService: QuoteService,
    private val quoteDatabase: QuoteDatabase,
    private val applicationContext: Context
) {

    private val quoteLiveData = MutableLiveData<QuoteList>()

    val quotes: LiveData<QuoteList>
        get() = quoteLiveData

    suspend fun getQuotes(limit: Int, skip: Int) {

        if (NetworkUtils.isInternetAvailable(applicationContext)) {
            val result = quoteService.getQuote(limit, skip)
            if (result?.body() != null) {
                quoteDatabase.quoteDao().addQuotes(result.body()!!.quotes)
                quoteLiveData.postValue(result.body())

            }
        } else {
            val quotes = quoteDatabase.quoteDao().getQuotes()
            val quoteList = QuoteList(20, quotes, 1, 2)
            quoteLiveData.postValue(quoteList)
        }
    }
}
