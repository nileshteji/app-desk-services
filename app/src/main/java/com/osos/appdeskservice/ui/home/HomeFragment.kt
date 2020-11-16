package com.osos.appdeskservice.ui.home

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.google.android.gms.location.*
import com.osos.appdeskservice.R
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    lateinit var fusedLocationProviderClient: FusedLocationProviderClient


    @SuppressLint("MissingPermission")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // View Model Setup
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        // access location
        val locationRequest = LocationRequest().setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
        fusedLocationProviderClient.requestLocationUpdates( locationRequest, object : LocationCallback() {

            override fun onLocationResult(p0: LocationResult?) {
                    super.onLocationResult(p0)
                    homeViewModel.getWeather(p0!!.lastLocation.latitude,p0.lastLocation.longitude)
               }
            },
            Looper.myLooper()
        )



        homeViewModel.response.observe(viewLifecycleOwner){
            Log.d("LOGS", "onCreateView: ${it.name}" )
        }

        return root
    }






    override fun onAttach(context: Context) {
        super.onAttach(context)
        check()
    }


    fun check(){
        // fused api to access location
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(requireActivity())

        // check permissions
        if (ActivityCompat.checkSelfPermission(requireActivity(), Manifest.permission.ACCESS_FINE_LOCATION ) != PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission( requireActivity() , Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(requireActivity(), arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),100)
            return
        }
    }
}