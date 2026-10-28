package com.example.tarea6.data.models

import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    @SerializedName("current_weather")
    val currentWeather: CurrentWeather? = null,
    val daily: DailyWeather? = null
)

data class CurrentWeather(
    val temperature: Double? = null,
    val windspeed: Double? = null,
    val weathercode: Int? = null,
    val time: String? = null
)

data class DailyWeather(
    @SerializedName("temperature_2m_max")
    val maxTemp: List<Double>? = null,
    @SerializedName("temperature_2m_min")
    val minTemp: List<Double>? = null
)
