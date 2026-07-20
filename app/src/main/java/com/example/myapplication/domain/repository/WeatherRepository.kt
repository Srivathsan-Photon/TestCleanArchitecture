package com.example.myapplication.domain.repository

import com.example.myapplication.domain.model.Weather

interface WeatherRepository {
    suspend fun getWeather(latitude: Double, longitude: Double): Weather
}

