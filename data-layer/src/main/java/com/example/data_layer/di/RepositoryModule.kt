package com.example.data_layer.di

import com.example.data_layer.repository.TestRepositoryImpl
import com.example.domain_layer.TestRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindTestRepository(
        movieRepositoryImpl: TestRepositoryImpl
    ): TestRepository
}