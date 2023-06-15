package com.cvaldivia.mvvmproyecto.domain


import com.cvaldivia.mvvmproyecto.data.model.QuoteModel
import com.cvaldivia.mvvmproyecto.data.model.QuoteProvider

class GetRandomQuoteUseCase {

    operator fun invoke(): QuoteModel?{
        val quotes = QuoteProvider.quotes
        if(!quotes.isNullOrEmpty()){
            val randomNumer = (0..quotes.size - 1).random()
            return quotes[randomNumer]
        }
        return null
    }
}