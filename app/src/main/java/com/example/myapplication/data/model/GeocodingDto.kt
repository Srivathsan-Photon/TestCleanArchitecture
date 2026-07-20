package com.example.myapplication.data.model

data class GeocodingDto(
    val results: List<Result>
)

data class Result(
    val name: String,
    val latitude: Double,
    val longitude: Double
)
