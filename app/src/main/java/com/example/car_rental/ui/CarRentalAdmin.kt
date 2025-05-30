package com.example.car_rental.ui

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.car_rental.viewModel.CarRentalViewModel

class CarRentalAdmin : AppCompatActivity() {
    private lateinit var viewModel: CarRentalViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // xml needs to be implemented/ use jetpack compose
        setContentView(R.layout.activity_fleet_admin)

        viewModel = ViewModelProvider(this)[CarRentalViewModel::class.java]

        val speedInput = findViewById<EditText>(R.id.maxSpeedInput)
        val vehicleNo = findViewById<EditText>(R.id.vehicleNo)
        val saveButton = findViewById<Button>(R.id.saveSpeedButton)


        saveButton.setOnClickListener {
            val maxSpeed = speedInput.text.toString().toDoubleOrNull()
            val vehicleNo = speedInput.text.toString()
            if (maxSpeed != null) {
                viewModel.setMaxSpeed(maxSpeed,vehicleNo)
            }
        }
    }

}