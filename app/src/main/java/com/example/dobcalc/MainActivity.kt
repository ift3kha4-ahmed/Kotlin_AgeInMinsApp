package com.example.dobcalc

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract
import android.widget.Button
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDatePicker: Button = findViewById(R.id.btnDatePicker)
        btnDatePicker.setOnClickListener {
             clickDatePicker()
        }

        }

    private  fun clickDatePicker(){
        val myCalendaer = Calendar.getInstance()
        val year = myCalendaer.get(Calendar.YEAR)
        val month = myCalendaer.get(Calendar.MONTH)
        val day = myCalendaer.get(Calendar.DAY_OF_MONTH )

        DatePickerDialog(this,
            {view, year, month, dayOfMonth ->

                Toast.makeText(this, "The date picker works", Toast.LENGTH_SHORT).show()
            },
            year,
            month,
            day
        ).show()

    }


}
