package com.example.mvvm_rrtrofit_room

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_rrtrofit_room.api.QuoteService
import com.example.mvvm_rrtrofit_room.api.RetrofitHelper
import com.example.mvvm_rrtrofit_room.repository.QuotesRepository
import com.example.mvvm_rrtrofit_room.viewModels.MainViewModel
import com.example.mvvm_rrtrofit_room.viewModels.MainViewModelFactory
import retrofit2.create

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val repository = (application as QuoteApplication).quotesRepository

        mainViewModel = ViewModelProvider(this,MainViewModelFactory(repository)).get(MainViewModel::class.java)

        mainViewModel.quotes.observe(this){
            Toast.makeText(this@MainActivity,it.quotes.size.toString(),Toast.LENGTH_SHORT).show()
        }
    }
}