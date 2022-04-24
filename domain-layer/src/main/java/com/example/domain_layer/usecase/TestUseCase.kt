package com.example.domain_layer.usecase

import com.example.domain_layer.TestRepository
import com.example.domain_layer.model.Question
import com.example.domain_layer.model.state.Resource
import com.example.domain_layer.usecase.base.SuspendUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TestUseCase @Inject constructor(
    private val testRepository: TestRepository,
) : SuspendUseCase<Unit, @JvmSuppressWildcards Flow<Resource<List<Question>>>> {

    override suspend fun execute(params: Unit) =
        testRepository.getTestQuestions()

}