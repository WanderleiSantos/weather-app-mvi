package com.wanderlei.weatherappmvi.presentation

import com.wanderlei.weatherappmvi.domain.weather.WeatherInfo

data class WeatherState(
    val weatherInfo: WeatherInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null,
)
