package com.Oss.weatherapp.repository

import com.Oss.weatherapp.utils.Constants.apiKey
import com.Oss.weatherapp.utils.api.RetrofitInstance
import com.Oss.weatherapp.utils.data.WeatherCallBack

class Repository {

    suspend fun getCurrentTemp(
        lat: Double,
        long: Double
    ): WeatherCallBack =
        RetrofitInstance.api.getCurrentTempCoordinates(
            lat = lat,
            long = long,
            apiKey = apiKey
        )

}