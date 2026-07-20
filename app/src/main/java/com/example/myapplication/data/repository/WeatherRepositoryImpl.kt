package com.example.myapplication.data.repository

import com.example.myapplication.data.mapper.toDomain
import com.example.myapplication.data.remote.WeatherService
import com.example.myapplication.domain.model.Weather
import com.example.myapplication.domain.repository.WeatherRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeatherRepositoryImpl @Inject constructor(
    private val service: WeatherService
) : WeatherRepository {
    override suspend fun getWeather(latitude: Double, longitude: Double): Weather {
        return service.getWeather(latitude, longitude).toDomain()
    }
}
