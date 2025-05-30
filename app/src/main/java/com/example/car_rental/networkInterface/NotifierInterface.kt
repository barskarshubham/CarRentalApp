package com.example.car_rental.networkInterface

interface NotifierInterface {
    fun sendAlert(userToken:String, phoneNo:String, message: String)
}