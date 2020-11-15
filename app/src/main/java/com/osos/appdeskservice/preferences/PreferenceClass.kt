package com.osos.appdeskservice.preferences

import android.content.Context
import android.content.SharedPreferences
import com.osos.appdeskservice.data.Constants
import com.osos.appdeskservice.data.Temp


class PreferenceClass(var context: Context) {


    var mPref: SharedPreferences


    init {
        mPref = context.getSharedPreferences(Constants.PREF_NAME, Context.MODE_PRIVATE)
    }

    fun insertTemperature(a: Temp) {
        mPref.edit().putString(Constants.PREF_TEMP, a.name)
    }

    fun getTemperature(): String? {
        return mPref.getString(Constants.PREF_TEMP, Temp.CEL.name)
    }

    fun insertUserName(a: String) {
        mPref.edit().putString(Constants.PREF_USER, a)
    }

    fun getUsername(): String? {
        return mPref.getString(Constants.PREF_USER, null)
    }


}