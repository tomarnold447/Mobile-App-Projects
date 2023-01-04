package com.example.twoactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Inflate the UI -- ie transforming the XML Layout into Java/Kotlin objects to work with
        setContentView(R.layout.activity_main)

        //Create a reference/object to access the XML element EditText with the id editText_send
        val mMessageEditText: EditText = findViewById(R.id.editText_send)
        var reply: TextView = findViewById(R.id.replymsg)

        //
        //Create a reference/object to access the XML Button with the id button_send
        val buttonSend: Button = this.findViewById(R.id.button_send)
        //var textView: TextView = findViewById(R.id.text_message)
        val message = intent.getStringExtra("SEND_KEY_VALUE")
        reply.text = message

        buttonSend.setOnClickListener {
            //an intent object linking this current activity to the second/next one to be opened
            val secondActivityIntent = Intent(this, SecondActivity::class.java)

            //extract message typed by user as a string, in a variable called message
            var message = mMessageEditText.text.toString().trim() //trim removes extra spaces

            //SEND_KEY_VALUE key will be used in the next activity to retrieve the message
            secondActivityIntent.putExtra("SEND_KEY_VALUE", message)

            //call for the SecondActivity to be started
            startActivity(secondActivityIntent)//starting the secondActivity when button is clicked

        }
    }
}