package com.example.presentation_layer.ui.test

import androidx.lifecycle.viewModelScope
import com.example.domain_layer.model.Question
import com.example.domain_layer.model.state.Resource
import com.example.domain_layer.usecase.TestUseCase
import com.example.presentation_layer.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TestViewModel @Inject constructor(
    private val testUseCase: TestUseCase,
) : BaseViewModel<Resource<List<Question>>>() {

    fun getQuestions() {
        viewModelScope.launch {
            uiState.value = Resource.Loading()
            testUseCase.execute(Unit).collect {
                uiState.value = it
            }
        }
    }
}