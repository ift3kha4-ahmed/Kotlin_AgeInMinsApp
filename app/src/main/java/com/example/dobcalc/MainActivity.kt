package com.example.dobcalc

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private var tvSelectedDate :TextView? = null

    private var tvAgeInMins: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDatePicker: Button = findViewById(R.id.btnDatePicker)
        tvSelectedDate = findViewById(R.id.SelectedDateDisplay)
        tvAgeInMins = findViewById(R.id.tvAgeInMins)
        btnDatePicker.setOnClickListener {
             clickDatePicker()
        }

        }

    private  fun clickDatePicker(){
        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH )
        val dpd =
            DatePickerDialog(this,
                { _, SelectedYear, SelectedMonth, SelectedDayOfMonth ->


                    val selectedDate = "$SelectedDayOfMonth / ${SelectedMonth+1} / $SelectedYear"

                    tvSelectedDate?.text = selectedDate

                    val sdf = SimpleDateFormat("dd / MM / yyyy", Locale.ENGLISH)

                    val theDate = sdf.parse(selectedDate)

                    theDate?.let {
                        val selectedDateInMinutes = theDate.time /60000

                        val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))

                        currentDate?.let {
                            val currentDateInMinutes = currentDate.time /60000

                            val differInMinutes =  currentDateInMinutes - selectedDateInMinutes

                            tvAgeInMins?.text = differInMinutes.toString()
                        }

                    }


                },
                year,
                month,
                day
            )
        dpd.datePicker.maxDate = System.currentTimeMillis() - 86400000
        dpd.show()

    }


}
