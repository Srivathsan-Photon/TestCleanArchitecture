package com.example.myapplication.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.usecase.GetWeatherUseCase
import com.example.myapplication.domain.usecase.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(private val getWeatherUseCase: GetWeatherUseCase) :
    ViewModel() {

    private val _uiState = MutableStateFlow<Resource<Any>>(Resource.Idle)
    val uiState: StateFlow<Resource<Any>> = _uiState.asStateFlow()

    fun search(city: String) {
        viewModelScope.launch {
            getWeatherUseCase(city).collect { res ->
                _uiState.value = when (res) {
                    is Resource.Idle -> Resource.Idle
                    is Resource.Loading -> Resource.Loading
                    is Resource.Error -> Resource.Error(res.message)
                    is Resource.Success -> Resource.Success(res.data)
                }
            }
        }
    }
}
