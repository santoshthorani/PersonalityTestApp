package com.example.data_layer.repository

import com.example.data_layer.di.IoDispatcher
import com.example.domain_layer.TestRepository
import com.example.domain_layer.model.Question
import com.example.domain_layer.model.state.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class TestRepositoryImpl @Inject constructor(
    private val remoteData: RemoteData,
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
) : TestRepository {
    override suspend fun getTestQuestions(): Flow<Resource<List<Question>>> {
        return flow {
            emit(remoteData.getTestQuestions())
        }.flowOn(dispatcher)
    }
}