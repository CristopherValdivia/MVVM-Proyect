package com.cvaldivia.mvvmproyecto.ui.theme.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cvaldivia.mvvmproyecto.data.model.QuoteModel
import com.cvaldivia.mvvmproyecto.data.model.QuoteProvider
import com.cvaldivia.mvvmproyecto.domain.GetQuotesUseCase
import com.cvaldivia.mvvmproyecto.domain.GetRandomQuoteUseCase
import kotlinx.coroutines.launch

class QuoteViewModel : ViewModel(){

    val quoteModel = MutableLiveData<QuoteModel>()
    val isLoading = MutableLiveData<Boolean>()

    var getQuotesUseCase = GetQuotesUseCase()
    var getRandomQuoteUseCase = GetRandomQuoteUseCase()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getQuotesUseCase()

            if(!result.isNullOrEmpty()){
                quoteModel.postValue(result[0])
                isLoading.postValue(false)
            }

        }
    }

    fun randonQuote(){
        isLoading.postValue(true)

        val quote = getRandomQuoteUseCase()
        if(quote!=null){
            quoteModel.postValue(quote)
        }

        isLoading.postValue(false)

    }


}