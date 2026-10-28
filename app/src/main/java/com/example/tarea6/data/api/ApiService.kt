package com.example.tarea6.data.api

import com.example.tarea6.data.models.GenderizeResponse
import com.example.tarea6.data.models.PokemonResponse
import com.example.tarea6.data.models.RandomUserResponse
import com.example.tarea6.data.models.University
import com.example.tarea6.data.models.WeatherResponse
import com.example.tarea6.data.models.WordPressPost
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface ApiService {
    @GET("https://api.genderize.io/")
    suspend fun getGender(@Query("name") name: String): GenderizeResponse

    @GET("https://randomuser.me/api/?results=1")
    suspend fun getRandomUser(): RandomUserResponse

    @GET
    suspend fun getUniversitiesByUrl(@Url url: String): List<University>

    @GET("https://api.open-meteo.com/v1/forecast?latitude=18.4861&longitude=-69.9312&current_weather=true&daily=temperature_2m_max,temperature_2m_min&timezone=America%2FSanto_Domingo")
    suspend fun getDRWeather(): WeatherResponse

    @GET
    suspend fun getPokemonByUrl(@Url url: String): PokemonResponse

    @GET
    suspend fun getWordPressPostsByUrl(@Url url: String): List<WordPressPost>
}
