package com.example.mvvm_rrtrofit_room.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm_rrtrofit_room.models.QuoteList
import com.example.mvvm_rrtrofit_room.repository.QuotesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(val repository: QuotesRepository):ViewModel() {

    init {
        viewModelScope.launch (Dispatchers.IO) {
            repository.getQuotes(5,0)
        }
    }

    val quotes: LiveData<QuoteList>
        get() = repository.quotes
}