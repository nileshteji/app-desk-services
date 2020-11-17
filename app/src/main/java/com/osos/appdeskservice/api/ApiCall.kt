package com.osos.appdeskservice.api

import com.osos.appdeskservice.data.Response
import com.osos.appdeskservice.data.SevenDayResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiCall {

//    api.openweathermap.org/data/2.5/weather?lat={lat}&lon={lon}&appid={API key}


    @GET("data/2.5/weather")

    suspend fun getWeather(

      @Query("lat") lat: String,
      @Query("lon") lon: String,
      @Query("appid") key: String,
      @Query("units") unit: String

    ): Response


    @GET("data/2.5/onecall")

    suspend fun sevenDayWeather(

        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("appid") key: String,
        @Query("units") unit: String

    ) :SevenDayResponse

}


