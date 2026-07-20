package com.example.myapplication.data.repository

import com.example.myapplication.data.mapper.toDomain
import com.example.myapplication.data.remote.GeocodingService
import com.example.myapplication.domain.model.Geocoding
import com.example.myapplication.domain.repository.GeocodingRepository
import javax.inject.Inject

class GeocodingRepositoryImpl @Inject constructor(
    private val service: GeocodingService
) : GeocodingRepository {
    override suspend fun getGeocoding(city: String): Geocoding {
        return service.getGeocoding(city).toDomain()
    }
}