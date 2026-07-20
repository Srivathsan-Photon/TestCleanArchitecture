package com.example.myapplication.data.model

data class WeatherDto(
    val latitude: Double,
    val longitude: Double,
    val current: Current
)

data class Current(
    val temperature_2m: Double
)
