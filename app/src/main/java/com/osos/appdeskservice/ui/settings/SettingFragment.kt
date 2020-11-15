package com.osos.appdeskservice.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.osos.appdeskservice.R
import kotlinx.android.synthetic.main.fragment_notifications.*

class SettingFragment : Fragment() {

    private lateinit var settingsViewModel: SettingsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        settingsViewModel =
            ViewModelProvider(this).get(SettingsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_notifications, container, false)

        settingsViewModel.getUserName(requireActivity())
        settingsViewModel.userName.observe(viewLifecycleOwner){

        }

        return root
    }
}