package com.example.car_rental.network

import com.example.car_rental.NotifierInterface
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.RemoteMessage

class FirebaseNotifier :NotifierInterface{

    override fun sendAlert(userToken: String, phoneNo: String, message: String) {
        val remoteMessage = RemoteMessage.Builder(userToken)
            .addData("alert", message)
            .build()

        FirebaseMessaging.getInstance().send(remoteMessage)
    }

}