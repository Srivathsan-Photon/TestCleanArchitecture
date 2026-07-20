package com.example.myapplication.data.mapper

import com.example.myapplication.data.model.GeocodingDto
import com.example.myapplication.domain.model.Geocoding

fun GeocodingDto.toDomain(): Geocoding {
    return Geocoding(
        name = this.results[0].name,
        latitude = this.results[0].latitude,
        longitude = this.results[0].longitude
    )
}