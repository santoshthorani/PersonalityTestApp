package com.example.data_layer.repository

import com.example.domain_layer.model.Question
import com.example.domain_layer.model.state.Resource

interface RemoteDataSource {
    suspend fun getTestQuestions(): Resource<List<Question>>
}