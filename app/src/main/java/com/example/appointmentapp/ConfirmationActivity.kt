package com.example.appointmentapp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ConfirmationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_confirmation)

        val name = intent.getStringExtra("name")
        val phone = intent.getStringExtra("phone")
        val email = intent.getStringExtra("email")
        val type = intent.getStringExtra("type")
        val gender = intent.getStringExtra("gender")

        val result = findViewById<TextView>(R.id.txtResult)

        result.text = """
            Appointment Confirmed!
            
            Name: $name
            Phone: $phone
            Email: $email
            Type: $type
            Gender: $gender
        """.trimIndent()
    }
}