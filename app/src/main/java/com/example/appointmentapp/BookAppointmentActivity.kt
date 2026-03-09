package com.example.appointmentapp

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class BookAppointmentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_book_appointment)

        val name = findViewById<EditText>(R.id.etName)
        val phone = findViewById<EditText>(R.id.etPhone)
        val email = findViewById<EditText>(R.id.etEmail)
        val spinner = findViewById<Spinner>(R.id.spinnerType)
        val checkbox = findViewById<CheckBox>(R.id.checkTerms)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGender)
        val button = findViewById<Button>(R.id.btnConfirm)

        val options = arrayOf(
            "Doctor Consultation",
            "Dentist Appointment",
            "Eye Specialist",
            "Skin Specialist",
            "General Checkup"
        )

        spinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, options)

        button.setOnClickListener {

            val n = name.text.toString()
            val p = phone.text.toString()
            val e = email.text.toString()

            if (n.isEmpty()) {
                name.error = "Enter Name"
                return@setOnClickListener
            }

            if (p.isEmpty()) {
                phone.error = "Enter Phone"
                return@setOnClickListener
            }

            if (e.isEmpty()) {
                email.error = "Enter Email"
                return@setOnClickListener
            }

            if (!checkbox.isChecked) {
                Toast.makeText(this, "Accept Terms", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val genderId = radioGroup.checkedRadioButtonId
            val gender = findViewById<RadioButton>(genderId).text.toString()

            val intent = Intent(this, ConfirmationActivity::class.java)

            intent.putExtra("name", n)
            intent.putExtra("phone", p)
            intent.putExtra("email", e)
            intent.putExtra("type", spinner.selectedItem.toString())
            intent.putExtra("gender", gender)

            startActivity(intent)

        }
    }
}