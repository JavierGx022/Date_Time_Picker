package com.componentes.timepicker

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.componentes.timepicker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

           binding.etHora.setOnClickListener{
               showTimePicker()
           }

        binding.etFecha.setOnClickListener{
            showDatePicker()
        }


    }


    private fun showTimePicker(){
        val timePicker= TimePickerFragment{time->
            onTimeSelected(time)
        }
        timePicker.show(supportFragmentManager, "time")
    }

    fun onTimeSelected(time:String){
        binding.etHora.setText("ha seleccionado las $time")
    }

    private fun showDatePicker(){
        val datePicker= DatePickerFragment{
            day,month,year->onDateSelected(day, month,year)
        }
        datePicker.show(supportFragmentManager, "date")
    }

    private fun onDateSelected(day:Int, month:Int, year:Int){
        binding.etFecha.setText("fecha seleccionada: $day/$month/$year")
    }


}