package com.wanderlei.weatherappmvi.data.repository

import com.wanderlei.weatherappmvi.data.mappers.toWeatherInfo
import com.wanderlei.weatherappmvi.data.remote.WeatherApi
import com.wanderlei.weatherappmvi.domain.repository.WeatherRepository
import com.wanderlei.weatherappmvi.domain.util.Resource
import com.wanderlei.weatherappmvi.domain.weather.WeatherInfo
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi,
) : WeatherRepository {

    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                data = api.getWeatherData(
                    lat = lat,
                    long = long
                ).toWeatherInfo()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }
}