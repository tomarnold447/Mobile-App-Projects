package com.example.hellotoast

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random
import kotlin.random.nextInt

class MainActivity : AppCompatActivity() {
    private var mCount=0
    private val int = 1
    private var mShowCount:TextView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mShowCount = findViewById(R.id.show_count)
    }

    fun showToast(view: View){
        Toast.makeText(this,"Hello Toast!" ,Toast.LENGTH_SHORT).show()
    }

    fun rollingDice(view: View){
        var rnds = (1..6).random()
        mShowCount!!.text=rnds.toString()
    }

    fun countUP(view:View){
        mCount++
        if(mShowCount != null){
            mShowCount!!.text=mCount.toString()
        }
    }

}