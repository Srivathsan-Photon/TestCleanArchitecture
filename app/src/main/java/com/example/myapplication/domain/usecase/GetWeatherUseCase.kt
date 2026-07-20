package com.example.myapplication.domain.usecase

import com.example.myapplication.domain.model.Weather
import com.example.myapplication.domain.repository.GeocodingRepository
import com.example.myapplication.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

sealed interface Resource<out T> {
    object Idle : Resource<Nothing>
    object Loading : Resource<Nothing>
    data class Success(val data: Weather) : Resource<Weather>
    data class Error(val message: String?) : Resource<Nothing>
}

class GetWeatherUseCase @Inject constructor(
    private val geocodingRepository: GeocodingRepository,
    private val weatherRepository: WeatherRepository
) {
    operator fun invoke(city: String): Flow<Resource<Weather>> = flow {
        emit(Resource.Loading)
        val geocoding = geocodingRepository.getGeocoding(city)
        val weather = weatherRepository.getWeather(geocoding.latitude, geocoding.longitude)
        emit(Resource.Success(weather))
    }.catch { e -> emit(Resource.Error(e.message)) }
}
