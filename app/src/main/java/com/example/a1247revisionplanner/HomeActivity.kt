package com.example.a1247revisionplanner

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_home.*
import java.util.*

class HomeActivity : AppCompatActivity() {
        private var parsedDate = ""

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_home)

                // Creating calendar object
                var cal:Calendar = Calendar.getInstance()

                // Setting date picker dialog box on click of date button
                btnDate.setOnClickListener {
                    DatePickerDialog(
                        this,
                        DatePickerDialog.OnDateSetListener { _, yy, mm, dd ->
                            parsedDate = "$dd/${mm+1}/$yy"
                            tvViewDate.text = parsedDate
                        },
                        cal.get(Calendar.YEAR),
                        cal.get(Calendar.MONTH),
                        cal.get(Calendar.DAY_OF_MONTH)
                    ).show()
                }

                // Passing data to other activity
                btnPlan.setOnClickListener{
                    Intent(this,RevisionActivity::class.java).also{
                        it.putExtra("EXTRA_TASK",etTask.text.toString())
                        it.putExtra("EXTRA_DATE",parsedDate)
                        startActivity(it)
                    }

                }


        }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_bar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.miAbout -> {
                Intent(this,AboutActivity::class.java).also {
                    startActivity(it)
                }
            }

            R.id.miHelp -> {
                Intent(this, HelpActivity::class.java).also {
                    startActivity(it)
                }
            }

            R.id.miClose -> {
                finish()
            }
        }
        return true
    }

}