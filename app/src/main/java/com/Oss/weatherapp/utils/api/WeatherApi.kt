package com.Oss.weatherapp.utils.api

import com.Oss.weatherapp.utils.data.WeatherCallBack
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherApi {

    @GET("weather")
    suspend fun getCurrentTempCoordinates(
        @Query("lat")
        lat: Double,
        @Query("lon")
        long: Double,
        @Query("appid")
        apiKey: String
    ): WeatherCallBack
}