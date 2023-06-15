package com.cvaldivia.mvvmproyecto.domain

import com.cvaldivia.mvvmproyecto.data.QuoteRepository
import com.cvaldivia.mvvmproyecto.data.model.QuoteModel

class GetQuotesUseCase {

    private val repository = QuoteRepository()

    suspend operator fun invoke():List<QuoteModel>? = repository.getAllQuotes()

}