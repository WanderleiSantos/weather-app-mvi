package com.wanderlei.weatherappmvi.domain.repository

import com.wanderlei.weatherappmvi.domain.util.Resource
import com.wanderlei.weatherappmvi.domain.weather.WeatherInfo

interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo>
}