package com.example.car_rental.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.car_rental.data.FirestoreService
import com.example.car_rental.data.UserSpeedData
import com.example.car_rental.network.AwsNotifier
import com.example.car_rental.network.FirebaseNotifier
import com.example.car_rental.sensor.SpeedSensor
import com.example.car_rental.service.MyFirebaseInstanceIDService

class CarRentalViewModel: ViewModel() {

    var currentSpeed = 0.0
    val _speedAlert = MutableLiveData<String?>()
    val speedAlert: LiveData<String?> get() = _speedAlert

    fun getCurrentSpeed() :Double {
        // get speed from car sensors and assign value to currentSpeed
        return SpeedSensor().getCurrentSpeedFromSensors()
    }
    fun checkSpeedLimitExceeded(userId: String) {
        FirestoreService.getSpeedLimit(userId) { maxSpeed ->
            if (maxSpeed != null) {
                val carRentalData = UserSpeedData(userId ,currentSpeed, maxSpeed)
                if (carRentalData.isSpeedAboveLimit()) {
                    sendAlert("Speed limit exceeded! Slow down.")
                }
            }
        }
    }

    private fun sendAlert(message: String) {
        // Call Firebase Messaging to notify renter
        //give alert to the user
        if(!message.isNullOrEmpty()) {
            _speedAlert.postValue(message)
            //send alert to car rental company
            FirebaseNotifier().sendNotification(MyFirebaseInstanceIDService().getToken(),message)
            AwsNotifier().sendAlert("1234566789",message)
        }
        else
            _speedAlert.postValue(null)

    }

    fun setMaxSpeed(maxSpeed: Double, vehicleNo: String) {
        if (maxSpeed != 0.0) {
            FirestoreService.setSpeedLimit(vehicleNo, maxSpeed)
        }


    }

}