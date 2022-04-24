package com.example.domain_layer

import com.example.domain_layer.model.Question
import com.example.domain_layer.model.state.Resource
import kotlinx.coroutines.flow.Flow

interface TestRepository {
    suspend fun getTestQuestions(): Flow<Resource<List<Question>>>
}