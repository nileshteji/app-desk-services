package com.osos.appdeskservice.ui.date

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.osos.appdeskservice.data.DateResponse

class DateViewModel : ViewModel() {




    var history :MutableLiveData<DateResponse> = MutableLiveData()




    fun fetchResponse(){

    }



}