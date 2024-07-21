package com.example.mvvm_rrtrofit_room

import android.app.Application
import androidx.constraintlayout.widget.ConstraintSet.Constraint
import androidx.constraintlayout.widget.Constraints
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import com.example.mvvm_rrtrofit_room.api.QuoteService
import com.example.mvvm_rrtrofit_room.api.RetrofitHelper
import com.example.mvvm_rrtrofit_room.repository.QuotesRepository
import com.example.mvvm_rrtrofit_room.roomDB.QuoteDatabase
import com.example.mvvm_rrtrofit_room.worker.QuoteWorker
import java.util.concurrent.TimeUnit

class QuoteApplication : Application() {

    lateinit var quotesRepository: QuotesRepository
    override fun onCreate() {
        super.onCreate()
        initialize()
        setupWorker()
    }

    private fun setupWorker() {
        val constraint =
            androidx.work.Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED)
                .build()
        val workerRequest =
            PeriodicWorkRequest.Builder(QuoteWorker::class.java, 15, TimeUnit.MINUTES)
                .setConstraints(constraint).build()
        WorkManager.getInstance(this).enqueue(workerRequest)
    }

    private fun initialize() {
        val quoteService = RetrofitHelper.getInstance().create(QuoteService::class.java)
        val database = QuoteDatabase.getDatabAse(applicationContext)
        quotesRepository = QuotesRepository(quoteService, database, applicationContext)
    }
}