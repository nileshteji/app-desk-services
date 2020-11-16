package com.osos.appdeskservice.data

import com.google.gson.annotations.SerializedName

data class Main (

    @SerializedName("temp") var temp : Double,
    @SerializedName("feels_like") var feel : Double,
    @SerializedName("temp_min") var min : Double,
    @SerializedName("temp_max") var max : Double,

    )