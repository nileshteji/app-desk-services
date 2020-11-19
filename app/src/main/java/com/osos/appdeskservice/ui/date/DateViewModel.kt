package com.osos.appdeskservice.ui.date

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.osos.appdeskservice.api.ApiBuilder
import com.osos.appdeskservice.data.Constants
import com.osos.appdeskservice.data.DateResponse
import com.osos.appdeskservice.data.Places
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class DateViewModel : ViewModel() {


    var history: MutableLiveData<DateResponse> = MutableLiveData()
    lateinit var lat: String
    lateinit var long: String


    fun fetchResponse(place: Places, unix: Long, unit: String = "metric") {


        when (place) {

            Places.Delhi -> {

                lat = Constants.delhi_lat

                long = Constants.delhi_long

            }


            Places.Mumbai -> {

                lat = Constants.mumbai_lat

                long = Constants.mumbai_long

            }


            Places.Noida -> {

                lat = Constants.noida_lat

                long = Constants.noida_long

            }


        }


        viewModelScope.launch {

            val job = async {
                ApiBuilder.getApiCall()
                    .getHistory(lat, long, unix.toString(), Constants.API_KEY, unit)
            }

            history.value = job.await()

        }

    }


}