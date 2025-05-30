package com.example.car_rental.notifier

interface NotifierInterface {
    fun sendAlert(userToken:String, phoneNo:String, message: String)
}