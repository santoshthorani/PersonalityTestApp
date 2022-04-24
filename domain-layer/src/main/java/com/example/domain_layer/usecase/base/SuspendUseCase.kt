package com.example.domain_layer.usecase.base

interface SuspendUseCase<in Params, out T> {
    suspend fun execute(params: Params) : T
}