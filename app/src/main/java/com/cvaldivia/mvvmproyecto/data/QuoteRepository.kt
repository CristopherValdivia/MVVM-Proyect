package com.cvaldivia.mvvmproyecto.data

import com.cvaldivia.mvvmproyecto.data.model.QuoteModel
import com.cvaldivia.mvvmproyecto.data.model.QuoteProvider
import com.cvaldivia.mvvmproyecto.data.network.QuoteService

class QuoteRepository {

    private val api = QuoteService()

    suspend fun getAllQuotes():List<QuoteModel>{
        val response : List<QuoteModel> = api.getQuotes()
        QuoteProvider.quotes = response
        return response
    }
}