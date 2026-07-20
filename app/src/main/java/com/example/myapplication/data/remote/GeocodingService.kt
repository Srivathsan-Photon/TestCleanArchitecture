package com.example.myapplication.data.remote

import com.example.myapplication.data.model.GeocodingDto
import retrofit2.http.GET
import retrofit2.http.Query

interface GeocodingService {

    @GET("v1/search")
    suspend fun getGeocoding(
        @Query("name") name: String
    ): GeocodingDto
}