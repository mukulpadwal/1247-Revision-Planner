package com.example.a1247revisionplanner

import android.content.Intent
import android.os.Bundle
import android.provider.CalendarContract
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_revision.*
import java.util.*

class RevisionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_revision)

        // Retrieving data passed from home activity
        var task = intent.getStringExtra("EXTRA_TASK")
        var date = intent.getStringExtra("EXTRA_DATE")


        try {
            // Extracting date month and year from date string
            var d = date?.subSequence(0, date.indexOf('/')).toString().toInt()
            var m = date?.subSequence(date.indexOf('/') + 1, date.lastIndexOf('/')).toString().toInt()
            var y = date?.subSequence(date.lastIndexOf('/') + 1, date.length).toString().toInt()

            var firstRevision = " "
            var secondRevision = " "
            var thirdRevision = " "

            // Logic for Revision Schedule
            when (m) {
                1 -> { // January
                    when (d) {
                        in 1..24 -> {
                            firstRevision = "${d + 1}/${m}/${y}"
                            secondRevision = "${d + 4}/${m}/${y}"
                            thirdRevision = "${d + 7}/${m}/${y}"
                        }
                        25 -> {
                            firstRevision = "${26}/${m}/${y}"
                            secondRevision = "${29}/${m}/${y}"
                            thirdRevision = "${1}/${m + 1}/${y}"
                        }
                        26 -> {
                            firstRevision = "${27}/${m}/${y}"
                            secondRevision = "${30}/${m}/${y}"
                            thirdRevision = "${2}/${m + 1}/${y}"
                        }
                        27 -> {
                            firstRevision = "${28}/${m}/${y}"
                            secondRevision = "${31}/${m}/${y}"
                            thirdRevision = "${3}/${m + 1}/${y}"
                        }
                        28 -> {
                            firstRevision = "${29}/${m}/${y}"
                            secondRevision = "${1}/${m + 1}/${y}"
                            thirdRevision = "${4}/${m + 1}/${y}"
                        }
                        29 -> {
                            firstRevision = "${30}/${m}/${y}"
                            secondRevision = "${2}/${m + 1}/${y}"
                            thirdRevision = "${5}/${m + 1}/${y}"
                        }
                        30 -> {
                            firstRevision = "${31}/${m}/${y}"
                            secondRevision = "${3}/${m + 1}/${y}"
                            thirdRevision = "${6}/${m + 1}/${y}"
                        }
                        31 -> {
                            firstRevision = "${1}/${m + 1}/${y}"
                            secondRevision = "${4}/${m + 1}/${y}"
                            thirdRevision = "${7}/${m + 1}/${y}"
                        }
                    }
                }
                2 -> {
                    if (y % 100 == 0) {// Century Year
                        if (y % 400 == 0) { //Leap Year
                            when (d) {
                                in 1..22 -> {
                                    firstRevision = "${d + 1}/${m}/${y}"
                                    secondRevision = "${d + 4}/${m}/${y}"
                                    thirdRevision = "${d + 7}/${m}/${y}"
                                }
                                23 -> {
                                    firstRevision = "${24}/${m}/${y}"
                                    secondRevision = "${27}/${m}/${y}"
                                    thirdRevision = "${1}/${m + 1}/${y}"
                                }
                                24 -> {
                                    firstRevision = "${25}/${m}/${y}"
                                    secondRevision = "${28}/${m}/${y}"
                                    thirdRevision = "${2}/${m + 1}/${y}"
                                }
                                25 -> {
                                    firstRevision = "${26}/${m}/${y}"
                                    secondRevision = "${29}/${m}/${y}"
                                    thirdRevision = "${3}/${m + 1}/${y}"
                                }
                                26 -> {
                                    firstRevision = "${27}/${m}/${y}"
                                    secondRevision = "${1}/${m + 1}/${y}"
                                    thirdRevision = "${4}/${m + 1}/${y}"
                                }
                                27 -> {
                                    firstRevision = "${28}/${m}/${y}"
                                    secondRevision = "${2}/${m + 1}/${y}"
                                    thirdRevision = "${5}/${m + 1}/${y}"
                                }
                                28 -> {
                                    firstRevision = "${29}/${m}/${y}"
                                    secondRevision = "${3}/${m + 1}/${y}"
                                    thirdRevision = "${6}/${m + 1}/${y}"
                                }
                                29 -> {
                                    firstRevision = "${1}/${m + 1}/${y}"
                                    secondRevision = "${4}/${m + 1}/${y}"
                                    thirdRevision = "${7}/${m + 1}/${y}"
                                }
                            }
                        } else { // Non-Leap Year
                            when (d) {
                                in 1..21 -> {
                                    firstRevision = "${d + 1}/${m}/${y}"
                                    secondRevision = "${d + 4}/${m}/${y}"
                                    thirdRevision = "${d + 7}/${m}/${y}"
                                }
                                22 -> {
                                    firstRevision = "${23}/${m}/${y}"
                                    secondRevision = "${26}/${m}/${y}"
                                    thirdRevision = "${1}/${m + 1}/${y}"
                                }
                                23 -> {
                                    firstRevision = "${24}/${m}/${y}"
                                    secondRevision = "${27}/${m}/${y}"
                                    thirdRevision = "${2}/${m + 1}/${y}"
                                }
                                24 -> {
                                    firstRevision = "${25}/${m}/${y}"
                                    secondRevision = "${28}/${m}/${y}"
                                    thirdRevision = "${3}/${m + 1}/${y}"
                                }
                                25 -> {
                                    firstRevision = "${26}/${m}/${y}"
                                    secondRevision = "${1}/${m + 1}/${y}"
                                    thirdRevision = "${4}/${m + 1}/${y}"
                                }
                                26 -> {
                                    firstRevision = "${27}/${m}/${y}"
                                    secondRevision = "${2}/${m + 1}/${y}"
                                    thirdRevision = "${5}/${m + 1}/${y}"
                                }
                                27 -> {
                                    firstRevision = "${28}/${m}/${y}"
                                    secondRevision = "${3}/${m + 1}/${y}"
                                    thirdRevision = "${6}/${m + 1}/${y}"
                                }
                                28 -> {
                                    firstRevision = "${1}/${m + 1}/${y}"
                                    secondRevision = "${4}/${m + 1}/${y}"
                                    thirdRevision = "${7}/${m + 1}/${y}"
                                }
                            }
                        }
                    } else {
                        if (y % 4 == 0) { //Leap-Year
                            when (d) {
                                in 1..22 -> {
                                    firstRevision = "${d + 1}/${m}/${y}"
                                    secondRevision = "${d + 4}/${m}/${y}"
                                    thirdRevision = "${d + 7}/${m}/${y}"
                                }
                                23 -> {
                                    firstRevision = "${24}/${m}/${y}"
                                    secondRevision = "${27}/${m}/${y}"
                                    thirdRevision = "${1}/${m + 1}/${y}"
                                }
                                24 -> {
                                    firstRevision = "${25}/${m}/${y}"
                                    secondRevision = "${28}/${m}/${y}"
                                    thirdRevision = "${2}/${m + 1}/${y}"
                                }
                                25 -> {
                                    firstRevision = "${26}/${m}/${y}"
                                    secondRevision = "${29}/${m}/${y}"
                                    thirdRevision = "${3}/${m + 1}/${y}"
                                }
                                26 -> {
                                    firstRevision = "${27}/${m}/${y}"
                                    secondRevision = "${1}/${m + 1}/${y}"
                                    thirdRevision = "${4}/${m + 1}/${y}"
                                }
                                27 -> {
                                    firstRevision = "${28}/${m}/${y}"
                                    secondRevision = "${2}/${m + 1}/${y}"
                                    thirdRevision = "${5}/${m + 1}/${y}"
                                }
                                28 -> {
                                    firstRevision = "${29}/${m}/${y}"
                                    secondRevision = "${3}/${m + 1}/${y}"
                                    thirdRevision = "${6}/${m + 1}/${y}"
                                }
                                29 -> {
                                    firstRevision = "${1}/${m + 1}/${y}"
                                    secondRevision = "${4}/${m + 1}/${y}"
                                    thirdRevision = "${7}/${m + 1}/${y}"
                                }
                            }
                        } else { //Non-Leap Year
                            when (d) { // Non-Leap Year
                                in 1..21 -> {
                                    firstRevision = "${d + 1}/${m}/${y}"
                                    secondRevision = "${d + 4}/${m}/${y}"
                                    thirdRevision = "${d + 7}/${m}/${y}"
                                }
                                22 -> {
                                    firstRevision = "${23}/${m}/${y}"
                                    secondRevision = "${26}/${m}/${y}"
                                    thirdRevision = "${1}/${m + 1}/${y}"
                                }
                                23 -> {
                                    firstRevision = "${24}/${m}/${y}"
                                    secondRevision = "${27}/${m}/${y}"
                                    thirdRevision = "${2}/${m + 1}/${y}"
                                }
                                24 -> {
                                    firstRevision = "${25}/${m}/${y}"
                                    secondRevision = "${28}/${m}/${y}"
                                    thirdRevision = "${3}/${m + 1}/${y}"
                                }
                                25 -> {
                                    firstRevision = "${26}/${m}/${y}"
                                    secondRevision = "${1}/${m + 1}/${y}"
                                    thirdRevision = "${4}/${m + 1}/${y}"
                                }
                                26 -> {
                                    firstRevision = "${27}/${m}/${y}"
                                    secondRevision = "${2}/${m + 1}/${y}"
                                    thirdRevision = "${5}/${m + 1}/${y}"
                                }
                                27 -> {
                                    firstRevision = "${28}/${m}/${y}"
                                    secondRevision = "${3}/${m + 1}/${y}"
                                    thirdRevision = "${6}/${m + 1}/${y}"
                                }
                                28 -> {
                                    firstRevision = "${1}/${m + 1}/${y}"
                                    secondRevision = "${4}/${m + 1}/${y}"
                                    thirdRevision = "${7}/${m + 1}/${y}"
                                }
                            }
                        }
                    }
                }
                3 -> { // March
                    when (d) {
                        in 1..24 -> {
                            firstRevision = "${d + 1}/${m}/${y}"
                            secondRevision = "${d + 4}/${m}/${y}"
                            thirdRevision = "${d + 7}/${m}/${y}"
                        }
                        25 -> {
                            firstRevision = "${26}/${m}/${y}"
                            secondRevision = "${29}/${m}/${y}"
                            thirdRevision = "${1}/${m + 1}/${y}"
                        }
                        26 -> {
                            firstRevision = "${27}/${m}/${y}"
                            secondRevision = "${30}/${m}/${y}"
                            thirdRevision = "${2}/${m + 1}/${y}"
                        }
                        27 -> {
                            firstRevision = "${28}/${m}/${y}"
                            secondRevision = "${31}/${m}/${y}"
                            thirdRevision = "${3}/${m + 1}/${y}"
                        }
                        28 -> {
                            firstRevision = "${29}/${m}/${y}"
                            secondRevision = "${1}/${m + 1}/${y}"
                            thirdRevision = "${4}/${m + 1}/${y}"
                        }
                        29 -> {
                            firstRevision = "${30}/${m}/${y}"
                            secondRevision = "${2}/${m + 1}/${y}"
                            thirdRevision = "${5}/${m + 1}/${y}"
                        }
                        30 -> {
                            firstRevision = "${31}/${m}/${y}"
                            secondRevision = "${3}/${m + 1}/${y}"
                            thirdRevision = "${6}/${m + 1}/${y}"
                        }
                        31 -> {
                            firstRevision = "${1}/${m + 1}/${y}"
                            secondRevision = "${4}/${m + 1}/${y}"
                            thirdRevision = "${7}/${m + 1}/${y}"
                        }
                    }
                }
                4 -> { // April
                    when (d) {
                        in 1..23 -> {
                            firstRevision = "${d + 1}/${m}/${y}"
                            secondRevision = "${d + 4}/${m}/${y}"
                            thirdRevision = "${d + 7}/${m}/${y}"
                        }
                        24 -> {
                            firstRevision = "${25}/${m}/${y}"
                            secondRevision = "${29}/${m}/${y}"
                            thirdRevision = "${1}/${m + 1}/${y}"
                        }
                        25 -> {
                            firstRevision = "${26}/${m}/${y}"
                            secondRevision = "${30}/${m}/${y}"
                            thirdRevision = "${2}/${m + 1}/${y}"
                        }
                        26 -> {
                            firstRevision = "${27}/${m}/${y}"
                            secondRevision = "${31}/${m}/${y}"
                            thirdRevision = "${3}/${m + 1}/${y}"
                        }
                        27 -> {
                            firstRevision = "${28}/${m}/${y}"
                            secondRevision = "${1}/${m + 1}/${y}"
                            thirdRevision = "${4}/${m + 1}/${y}"
                        }
                        28 -> {
                            firstRevision = "${29}/${m}/${y}"
                            secondRevision = "${2}/${m + 1}/${y}"
                            thirdRevision = "${5}/${m + 1}/${y}"
                        }
                        29 -> {
                            firstRevision = "${30}/${m}/${y}"
                            secondRevision = "${3}/${m + 1}/${y}"
                            thirdRevision = "${6}/${m + 1}/${y}"
                        }
                        30 -> {
                            firstRevision = "${1}/${m + 1}/${y}"
                            secondRevision = "${4}/${m + 1}/${y}"
                            thirdRevision = "${7}/${m + 1}/${y}"
                        }
                    }
                }
                5 -> { // May
                    when (d) {
                        in 1..24 -> {
                            firstRevision = "${d + 1}/${m}/${y}"
                            secondRevision = "${d + 4}/${m}/${y}"
                            thirdRevision = "${d + 7}/${m}/${y}"
                        }
                        25 -> {
                            firstRevision = "${26}/${m}/${y}"
                            secondRevision = "${29}/${m}/${y}"
                            thirdRevision = "${1}/${m + 1}/${y}"
                        }
                        26 -> {
                            firstRevision = "${27}/${m}/${y}"
                            secondRevision = "${30}/${m}/${y}"
                            thirdRevision = "${2}/${m + 1}/${y}"
                        }
                        27 -> {
                            firstRevision = "${28}/${m}/${y}"
                            secondRevision = "${31}/${m}/${y}"
                            thirdRevision = "${3}/${m + 1}/${y}"
                        }
                        28 -> {
                            firstRevision = "${29}/${m}/${y}"
                            secondRevision = "${1}/${m + 1}/${y}"
                            thirdRevision = "${4}/${m + 1}/${y}"
                        }
                        29 -> {
                            firstRevision = "${30}/${m}/${y}"
                            secondRevision = "${2}/${m + 1}/${y}"
                            thirdRevision = "${5}/${m + 1}/${y}"
                        }
                        30 -> {
                            firstRevision = "${31}/${m}/${y}"
                            secondRevision = "${3}/${m + 1}/${y}"
                            thirdRevision = "${6}/${m + 1}/${y}"
                        }
                        31 -> {
                            firstRevision = "${1}/${m + 1}/${y}"
                            secondRevision = "${4}/${m + 1}/${y}"
                            thirdRevision = "${7}/${m + 1}/${y}"
                        }
                    }
                }
                6 -> { // June
                    when (d) {
                        in 1..23 -> {
                            firstRevision = "${d + 1}/${m}/${y}"
                            secondRevision = "${d + 4}/${m}/${y}"
                            thirdRevision = "${d + 7}/${m}/${y}"
                        }
                        24 -> {
                            firstRevision = "${25}/${m}/${y}"
                            secondRevision = "${29}/${m}/${y}"
                            thirdRevision = "${1}/${m + 1}/${y}"
                        }
                        25 -> {
                            firstRevision = "${26}/${m}/${y}"
                            secondRevision = "${30}/${m}/${y}"
                            thirdRevision = "${2}/${m + 1}/${y}"
                        }
                        26 -> {
                            firstRevision = "${27}/${m}/${y}"
                            secondRevision = "${31}/${m}/${y}"
                            thirdRevision = "${3}/${m + 1}/${y}"
                        }
                        27 -> {
                            firstRevision = "${28}/${m}/${y}"
                            secondRevision = "${1}/${m + 1}/${y}"
                            thirdRevision = "${4}/${m + 1}/${y}"
                        }
                        28 -> {
                            firstRevision = "${29}/${m}/${y}"
                            secondRevision = "${2}/${m + 1}/${y}"
                            thirdRevision = "${5}/${m + 1}/${y}"
                        }
                        29 -> {
                            firstRevision = "${30}/${m}/${y}"
                            secondRevision = "${3}/${m + 1}/${y}"
                            thirdRevision = "${6}/${m + 1}/${y}"
                        }
                        30 -> {
                            firstRevision = "${1}/${m + 1}/${y}"
                            secondRevision = "${4}/${m + 1}/${y}"
                            thirdRevision = "${7}/${m + 1}/${y}"
                        }
                    }
                }
                7 -> { // July
                    when (d) {
                        in 1..24 -> {
                            firstRevision = "${d + 1}/${m}/${y}"
                            secondRevision = "${d + 4}/${m}/${y}"
                            thirdRevision = "${d + 7}/${m}/${y}"
                        }
                        25 -> {
                            firstRevision = "${26}/${m}/${y}"
                            secondRevision = "${29}/${m}/${y}"
                            thirdRevision = "${1}/${m + 1}/${y}"
                        }
                        26 -> {
                            firstRevision = "${27}/${m}/${y}"
                            secondRevision = "${30}/${m}/${y}"
                            thirdRevision = "${2}/${m + 1}/${y}"
                        }
                        27 -> {
                            firstRevision = "${28}/${m}/${y}"
                            secondRevision = "${31}/${m}/${y}"
                            thirdRevision = "${3}/${m + 1}/${y}"
                        }
                        28 -> {
                            firstRevision = "${29}/${m}/${y}"
                            secondRevision = "${1}/${m + 1}/${y}"
                            thirdRevision = "${4}/${m + 1}/${y}"
                        }
                        29 -> {
                            firstRevision = "${30}/${m}/${y}"
                            secondRevision = "${2}/${m + 1}/${y}"
                            thirdRevision = "${5}/${m + 1}/${y}"
                        }
                        30 -> {
                            firstRevision = "${31}/${m}/${y}"
                            secondRevision = "${3}/${m + 1}/${y}"
                            thirdRevision = "${6}/${m + 1}/${y}"
                        }
                        31 -> {
                            firstRevision = "${1}/${m + 1}/${y}"
                            secondRevision = "${4}/${m + 1}/${y}"
                            thirdRevision = "${7}/${m + 1}/${y}"
                        }
                    }
                }
                8 -> { // August
                    when (d) {
                        in 1..24 -> {
                            firstRevision = "${d + 1}/${m}/${y}"
                            secondRevision = "${d + 4}/${m}/${y}"
                            thirdRevision = "${d + 7}/${m}/${y}"
                        }
                        25 -> {
                            firstRevision = "${26}/${m}/${y}"
                            secondRevision = "${29}/${m}/${y}"
                            thirdRevision = "${1}/${m + 1}/${y}"
                        }
                        26 -> {
                            firstRevision = "${27}/${m}/${y}"
                            secondRevision = "${30}/${m}/${y}"
                            thirdRevision = "${2}/${m + 1}/${y}"
                        }
                        27 -> {
                            firstRevision = "${28}/${m}/${y}"
                            secondRevision = "${31}/${m}/${y}"
                            thirdRevision = "${3}/${m + 1}/${y}"
                        }
                        28 -> {
                            firstRevision = "${29}/${m}/${y}"
                            secondRevision = "${1}/${m + 1}/${y}"
                            thirdRevision = "${4}/${m + 1}/${y}"
                        }
                        29 -> {
                            firstRevision = "${30}/${m}/${y}"
                            secondRevision = "${2}/${m + 1}/${y}"
                            thirdRevision = "${5}/${m + 1}/${y}"
                        }
                        30 -> {
                            firstRevision = "${31}/${m}/${y}"
                            secondRevision = "${3}/${m + 1}/${y}"
                            thirdRevision = "${6}/${m + 1}/${y}"
                        }
                        31 -> {
                            firstRevision = "${1}/${m + 1}/${y}"
                            secondRevision = "${4}/${m + 1}/${y}"
                            thirdRevision = "${7}/${m + 1}/${y}"
                        }
                    }
                }
                9 -> { // September
                    when (d) {
                        in 1..23 -> {
                            firstRevision = "${d + 1}/${m}/${y}"
                            secondRevision = "${d + 4}/${m}/${y}"
                            thirdRevision = "${d + 7}/${m}/${y}"
                        }
                        24 -> {
                            firstRevision = "${25}/${m}/${y}"
                            secondRevision = "${29}/${m}/${y}"
                            thirdRevision = "${1}/${m + 1}/${y}"
                        }
                        25 -> {
                            firstRevision = "${26}/${m}/${y}"
                            secondRevision = "${30}/${m}/${y}"
                            thirdRevision = "${2}/${m + 1}/${y}"
                        }
                        26 -> {
                            firstRevision = "${27}/${m}/${y}"
                            secondRevision = "${31}/${m}/${y}"
                            thirdRevision = "${3}/${m + 1}/${y}"
                        }
                        27 -> {
                            firstRevision = "${28}/${m}/${y}"
                            secondRevision = "${1}/${m + 1}/${y}"
                            thirdRevision = "${4}/${m + 1}/${y}"
                        }
                        28 -> {
                            firstRevision = "${29}/${m}/${y}"
                            secondRevision = "${2}/${m + 1}/${y}"
                            thirdRevision = "${5}/${m + 1}/${y}"
                        }
                        29 -> {
                            firstRevision = "${30}/${m}/${y}"
                            secondRevision = "${3}/${m + 1}/${y}"
                            thirdRevision = "${6}/${m + 1}/${y}"
                        }
                        30 -> {
                            firstRevision = "${1}/${m + 1}/${y}"
                            secondRevision = "${4}/${m + 1}/${y}"
                            thirdRevision = "${7}/${m + 1}/${y}"
                        }
                    }
                }
                10 -> { // October
                    when (d) {
                        in 1..24 -> {
                            firstRevision = "${d + 1}/${m}/${y}"
                            secondRevision = "${d + 4}/${m}/${y}"
                            thirdRevision = "${d + 7}/${m}/${y}"
                        }
                        25 -> {
                            firstRevision = "${26}/${m}/${y}"
                            secondRevision = "${29}/${m}/${y}"
                            thirdRevision = "${1}/${m + 1}/${y}"
                        }
                        26 -> {
                            firstRevision = "${27}/${m}/${y}"
                            secondRevision = "${30}/${m}/${y}"
                            thirdRevision = "${2}/${m + 1}/${y}"
                        }
                        27 -> {
                            firstRevision = "${28}/${m}/${y}"
                            secondRevision = "${31}/${m}/${y}"
                            thirdRevision = "${3}/${m + 1}/${y}"
                        }
                        28 -> {
                            firstRevision = "${29}/${m}/${y}"
                            secondRevision = "${1}/${m + 1}/${y}"
                            thirdRevision = "${4}/${m + 1}/${y}"
                        }
                        29 -> {
                            firstRevision = "${30}/${m}/${y}"
                            secondRevision = "${2}/${m + 1}/${y}"
                            thirdRevision = "${5}/${m + 1}/${y}"
                        }
                        30 -> {
                            firstRevision = "${31}/${m}/${y}"
                            secondRevision = "${3}/${m + 1}/${y}"
                            thirdRevision = "${6}/${m + 1}/${y}"
                        }
                        31 -> {
                            firstRevision = "${1}/${m + 1}/${y}"
                            secondRevision = "${4}/${m + 1}/${y}"
                            thirdRevision = "${7}/${m + 1}/${y}"
                        }
                    }
                }
                11 -> { // November
                    when (d) {
                        in 1..23 -> {
                            firstRevision = "${d + 1}/${m}/${y}"
                            secondRevision = "${d + 4}/${m}/${y}"
                            thirdRevision = "${d + 7}/${m}/${y}"
                        }
                        24 -> {
                            firstRevision = "${25}/${m}/${y}"
                            secondRevision = "${29}/${m}/${y}"
                            thirdRevision = "${1}/${m + 1}/${y}"
                        }
                        25 -> {
                            firstRevision = "${26}/${m}/${y}"
                            secondRevision = "${30}/${m}/${y}"
                            thirdRevision = "${2}/${m + 1}/${y}"
                        }
                        26 -> {
                            firstRevision = "${27}/${m}/${y}"
                            secondRevision = "${31}/${m}/${y}"
                            thirdRevision = "${3}/${m + 1}/${y}"
                        }
                        27 -> {
                            firstRevision = "${28}/${m}/${y}"
                            secondRevision = "${1}/${m + 1}/${y}"
                            thirdRevision = "${4}/${m + 1}/${y}"
                        }
                        28 -> {
                            firstRevision = "${29}/${m}/${y}"
                            secondRevision = "${2}/${m + 1}/${y}"
                            thirdRevision = "${5}/${m + 1}/${y}"
                        }
                        29 -> {
                            firstRevision = "${30}/${m}/${y}"
                            secondRevision = "${3}/${m + 1}/${y}"
                            thirdRevision = "${6}/${m + 1}/${y}"
                        }
                        30 -> {
                            firstRevision = "${1}/${m + 1}/${y}"
                            secondRevision = "${4}/${m + 1}/${y}"
                            thirdRevision = "${7}/${m + 1}/${y}"
                        }
                    }
                }
                12 -> { // December
                    when (d) {
                        in 1..24 -> {
                            firstRevision = "${d + 1}/${m}/${y}"
                            secondRevision = "${d + 4}/${m}/${y}"
                            thirdRevision = "${d + 7}/${m}/${y}"
                        }
                        25 -> {
                            firstRevision = "${26}/${m}/${y}"
                            secondRevision = "${29}/${m}/${y}"
                            thirdRevision = "${1}/${1}/${y + 1}"
                        }
                        26 -> {
                            firstRevision = "${27}/${m}/${y}"
                            secondRevision = "${30}/${m}/${y}"
                            thirdRevision = "${2}/${1}/${y + 1}"
                        }
                        27 -> {
                            firstRevision = "${28}/${m}/${y}"
                            secondRevision = "${31}/${m}/${y}"
                            thirdRevision = "${3}/${1}/${y + 1}"
                        }
                        28 -> {
                            firstRevision = "${29}/${m}/${y}"
                            secondRevision = "${1}/${1}/${y + 1}"
                            thirdRevision = "${4}/${1}/${y + 1}"
                        }
                        29 -> {
                            firstRevision = "${30}/${m}/${y}"
                            secondRevision = "${2}/${1}/${y + 1}"
                            thirdRevision = "${5}/${1}/${y + 1}"
                        }
                        30 -> {
                            firstRevision = "${31}/${m}/${y}"
                            secondRevision = "${3}/${1}/${y + 1}"
                            thirdRevision = "${6}/${1}/${y + 1}"
                        }
                        31 -> {
                            firstRevision = "${1}/${1}/${y + 1}"
                            secondRevision = "${4}/${1}/${y + 1}"
                            thirdRevision = "${7}/${1}/${y + 1}"
                        }
                    }
                }
            }

            // Displaying schedule
            tvTopic.text = "Topic : $task"
            tvFirstRevision.text = "First Revision Date : $firstRevision"
            tvSecondRevision.text = "Second Revision Date : $secondRevision"
            tvThirdRevision.text = "Third Revision Date : $thirdRevision"


            // logic to set reminder in calendar
            btnFirstNotify.setOnClickListener{

                // First Revision Day
                val fStartMillis: Long = Calendar.getInstance().run {
                    set(firstRevision?.subSequence(firstRevision.lastIndexOf('/') + 1, firstRevision.length).toString().toInt(),
                        firstRevision?.subSequence(firstRevision.indexOf('/') + 1, firstRevision.lastIndexOf('/')).toString().toInt()-1,
                        firstRevision?.subSequence(0, firstRevision.indexOf('/')).toString().toInt(),0,0)
                    timeInMillis
                }
                val fEndMillis: Long = Calendar.getInstance().run {
                    set(firstRevision?.subSequence(firstRevision.lastIndexOf('/') + 1, firstRevision.length).toString().toInt(),
                        firstRevision?.subSequence(firstRevision.indexOf('/') + 1, firstRevision.lastIndexOf('/')).toString().toInt()-1,
                        firstRevision?.subSequence(0, firstRevision.indexOf('/')).toString().toInt(),23,59)
                    timeInMillis
                }

                val fIntent = Intent(Intent.ACTION_INSERT)
                    .setData(CalendarContract.Events.CONTENT_URI)
                    .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, fStartMillis)
                    .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, fEndMillis)
                    .putExtra(CalendarContract.Events.TITLE, task)
                    .putExtra(CalendarContract.Events.AVAILABILITY, CalendarContract.Events.AVAILABILITY_BUSY)
                startActivity(fIntent)
            }

            btnSecondNotify.setOnClickListener{

                // Second Revision Day
                val sStartMillis: Long = Calendar.getInstance().run {
                    set(secondRevision?.subSequence(secondRevision.lastIndexOf('/') + 1, secondRevision.length).toString().toInt(),
                        secondRevision?.subSequence(secondRevision.indexOf('/') + 1, secondRevision.lastIndexOf('/')).toString().toInt()-1,
                        secondRevision?.subSequence(0, secondRevision.indexOf('/')).toString().toInt(),0,0)
                    timeInMillis
                }
                val sEndMillis: Long = Calendar.getInstance().run {
                    set(secondRevision?.subSequence(secondRevision.lastIndexOf('/') + 1, secondRevision.length).toString().toInt(),
                        secondRevision?.subSequence(secondRevision.indexOf('/') + 1, secondRevision.lastIndexOf('/')).toString().toInt()-1,
                        secondRevision?.subSequence(0, secondRevision.indexOf('/')).toString().toInt(),23,59)
                    timeInMillis
                }

                val sIntent = Intent(Intent.ACTION_INSERT)
                    .setData(CalendarContract.Events.CONTENT_URI)
                    .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, sStartMillis)
                    .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, sEndMillis)
                    .putExtra(CalendarContract.Events.TITLE, task)
                    .putExtra(CalendarContract.Events.AVAILABILITY, CalendarContract.Events.AVAILABILITY_BUSY)
                startActivity(sIntent)
            }

            btnThirdNotify.setOnClickListener{

                // Third Revision Day
                val tStartMillis: Long = Calendar.getInstance().run {
                    set(thirdRevision?.subSequence(thirdRevision.lastIndexOf('/') + 1, thirdRevision.length).toString().toInt(),
                        thirdRevision?.subSequence(thirdRevision.indexOf('/') + 1, thirdRevision.lastIndexOf('/')).toString().toInt()-1,
                        thirdRevision?.subSequence(0, thirdRevision.indexOf('/')).toString().toInt(),0,0)
                    timeInMillis
                }
                val tEndMillis: Long = Calendar.getInstance().run {
                    set(thirdRevision?.subSequence(thirdRevision.lastIndexOf('/') + 1, thirdRevision.length).toString().toInt(),
                        thirdRevision?.subSequence(thirdRevision.indexOf('/') + 1, thirdRevision.lastIndexOf('/')).toString().toInt()-1,
                        thirdRevision?.subSequence(0, thirdRevision.indexOf('/')).toString().toInt(),23,59)
                    timeInMillis
                }

                val tIntent = Intent(Intent.ACTION_INSERT)
                    .setData(CalendarContract.Events.CONTENT_URI)
                    .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, tStartMillis)
                    .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, tEndMillis)
                    .putExtra(CalendarContract.Events.TITLE, task)
                    .putExtra(CalendarContract.Events.AVAILABILITY, CalendarContract.Events.AVAILABILITY_BUSY)
                startActivity(tIntent)
            }


        } catch (e: StringIndexOutOfBoundsException) {
            Intent(this, HomeActivity::class.java).also {
                startActivity(it)
                Toast.makeText(
                    this,
                    "Seems Like You Didn't Select a Date, Please Select a date and then try again!!!",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

    }

}