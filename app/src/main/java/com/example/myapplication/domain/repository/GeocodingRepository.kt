package com.example.myapplication.domain.repository

import com.example.myapplication.domain.model.Geocoding

interface GeocodingRepository {

    suspend fun getGeocoding(city: String): Geocoding
}