package com.example.mvvm_rrtrofit_room

import android.app.Application
import com.example.mvvm_rrtrofit_room.api.QuoteService
import com.example.mvvm_rrtrofit_room.api.RetrofitHelper
import com.example.mvvm_rrtrofit_room.repository.QuotesRepository
import com.example.mvvm_rrtrofit_room.roomDB.QuoteDatabase

class QuoteApplication : Application() {

    lateinit var quotesRepository: QuotesRepository
    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {
        val quoteService = RetrofitHelper.getInstance().create(QuoteService::class.java)
        val database = QuoteDatabase.getDatabAse(applicationContext)
        quotesRepository = QuotesRepository(quoteService,database,applicationContext)
    }
}