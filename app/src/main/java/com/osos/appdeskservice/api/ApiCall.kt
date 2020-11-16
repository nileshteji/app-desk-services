package com.osos.appdeskservice.api

import com.osos.appdeskservice.data.Constants
import com.osos.appdeskservice.data.Response
import retrofit2.http.GET
import retrofit2.http.Query
import javax.security.auth.callback.Callback

interface ApiCall {

//    api.openweathermap.org/data/2.5/weather?lat={lat}&lon={lon}&appid={API key}


    @GET("data/2.5/weather")

      suspend fun getWeather(

        @Query("lat")   lat  : String,
        @Query("lon")   lon  : String,
        @Query("appid") key  : String

        ) : Response


}


