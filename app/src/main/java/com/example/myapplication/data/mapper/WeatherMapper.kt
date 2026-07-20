package com.example.myapplication.data.mapper

import com.example.myapplication.data.model.WeatherDto
import com.example.myapplication.domain.model.Weather

fun WeatherDto.toDomain(): Weather {
    return Weather(
        temperature = this.current.temperature_2m
    )
}