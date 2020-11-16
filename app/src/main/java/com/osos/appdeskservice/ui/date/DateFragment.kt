package com.osos.appdeskservice.ui.date

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.osos.appdeskservice.R

class DateFragment : Fragment() {

    companion object {
        fun newInstance() = DateFragment()
    }

    private lateinit var viewModel: DateViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_date, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DateViewModel::class.java)
        // TODO: Use the ViewModel
    }

}