package com.example.car_rental.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.car_rental.viewModel.CarRentalViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: CarRentalViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[CarRentalViewModel::class.java]
        viewModel.speedAlert.observe(this) { alertMessage ->
            if (!alertMessage.isNullOrEmpty()) {
                showAlert(alertMessage)
            }
        }
        checkSpeed()

    }
    fun checkSpeed() {
        lifecycleScope.launch {
            while (true) {
                viewModel.getCurrentSpeed()
                viewModel.checkSpeedLimitExceeded("XYZ987")
                delay(5000)
            }
        }
    }

    fun showAlert(alertMessage: String) {
        AlertDialog.Builder(this)
            .setTitle("Speed Alert")
            .setMessage(message)
            .setPositiveButton("OK") { _, _ -> }
            .show()
    }
}