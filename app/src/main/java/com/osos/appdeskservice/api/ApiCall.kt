package com.osos.appdeskservice.api

import com.osos.appdeskservice.data.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiCall {

//    api.openweathermap.org/data/2.5/weather?lat={lat}&lon={lon}&appid={API key}


    @GET("weather")
    suspend fun getCurrentWeather(

        @Query("lat")   a : String ,
        @Query("lon")   b : String ,
        @Query("appid") c : String = Constants.API_KEY,
        @Query("units") d : String = "metric" // celsius

    )
}