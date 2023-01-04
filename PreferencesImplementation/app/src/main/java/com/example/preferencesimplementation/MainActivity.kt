package com.example.preferencesimplementation

import android.content.Context
~~~~~~~
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var nameET: EditText = findViewById(R.id.editTextName)
        var ageET:EditText = findViewById(R.id.editTextAge)
        var btnSave: Button =findViewById(R.id.btnSave)
        var btnLoad: Button = findViewById(R.id.btnLoad)
        var checkAge: CheckBox =findViewById(R.id.ageCheck)

        var sharedPref = getSharedPreferences("myPref", Context.MODE_PRIVATE)

        var editor= sharedPref.edit()

        btnSave.setOnClickListener {
            var name= nameET.text.toString()
            var  age =ageET.text.toString().toInt()
            var  isAdult = checkAge.isChecked


            editor.putString("name",name)
            editor.putInt("age",age)
            editor.putBoolean("isAdult", isAdult)
            editor.apply()
            nameET.setText("")
            ageET.setText("")
            checkAge.isChecked= false

        }

        btnLoad.setOnClickListener {
            var name = sharedPref.getString("name", null)
            var age = sharedPref.getInt("age", 0)
            var isAdult = sharedPref.getBoolean("isAdult", false)

            nameET.setText(name)
            ageET.setText(age.toString())
            checkAge.isChecked = isAdult
        }
        }

    }
