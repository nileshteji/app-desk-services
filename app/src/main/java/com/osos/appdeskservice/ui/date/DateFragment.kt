package com.osos.appdeskservice.ui.date

import android.app.DatePickerDialog
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import android.widget.DatePicker
import com.osos.appdeskservice.R
import kotlinx.android.synthetic.main.fragment_date.*
import java.text.SimpleDateFormat
import java.util.*

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

        calendar_button.setOnClickListener(){

            val datePickerDialog=DatePickerDialog(
                requireContext(),
                DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->

                    Log.d("LOGS", "onActivityCreated: $year $month $dayOfMonth")
                    val date = SimpleDateFormat("dd-MM-yyyy").parse("$dayOfMonth-$month-$year")
                    Log.d("LOGS", "onActivityCreated: ${date.time} " )

                },
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)

            ).show()


        }




    }

}