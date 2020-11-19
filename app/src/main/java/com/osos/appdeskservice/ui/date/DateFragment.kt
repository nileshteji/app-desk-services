package com.osos.appdeskservice.ui.date

import android.annotation.SuppressLint
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
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter
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

    @SuppressLint("SimpleDateFormat")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DateViewModel::class.java)

        calendar_button.setOnClickListener(){

            val datePickerDialog=DatePickerDialog(
                requireContext(),
                DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                    val dt = convertToUnix(dayOfMonth,month, year)

                },
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)

            ).show()


        }




    }


    fun convertToUnix(dayOfMonth:Int , month:Int, year:Int ) :Long{
        val monthNew = month + 1

        val l = LocalDate.parse("$dayOfMonth-$monthNew-$year", DateTimeFormatter.ofPattern("dd-MM-yyyy"))

        val unix = l.atStartOfDay(ZoneId.systemDefault()).toInstant().epochSecond

        Log.d("LOGS", "onActivityCreated: $unix")

        return  unix

    }

}