package com.example.myapplication.di

import com.example.myapplication.data.repository.GeocodingRepositoryImpl
import com.example.myapplication.data.repository.WeatherRepositoryImpl
import com.example.myapplication.domain.repository.GeocodingRepository
import com.example.myapplication.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindWeatherRepository(impl: WeatherRepositoryImpl): WeatherRepository

    @Binds
    @Singleton
    abstract fun bindGeocodingRepository(impl: GeocodingRepositoryImpl): GeocodingRepository
}
