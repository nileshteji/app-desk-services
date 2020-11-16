package com.osos.appdeskservice.api

import com.osos.appdeskservice.data.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiBuilder {


    fun getRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    fun getApiCall():ApiCall{
        return getRetrofit().create(ApiCall::class.java)
    }

}