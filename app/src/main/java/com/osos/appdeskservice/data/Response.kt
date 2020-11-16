package com.osos.appdeskservice.data

import com.google.gson.annotations.SerializedName

data class Response(

    @SerializedName ("main") var main : Main,
    @SerializedName("name") var name: String,

    )