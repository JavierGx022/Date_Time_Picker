package com.componentes.timepicker

import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Context
import android.os.Bundle
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import java.util.Calendar

class TimePickerFragment(val listener:(String)->Unit):DialogFragment(), TimePickerDialog.OnTimeSetListener {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendar= Calendar.getInstance()
        val hora= calendar.get(Calendar.HOUR_OF_DAY)
        val minute= calendar.get(Calendar.MINUTE)
        val dialog= TimePickerDialog(activity as Context, this, hora, minute ,false)
        return dialog
    }
    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        listener("$hourOfDay:$minute")
    }
}