package com.example.car_rental.network

import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.RemoteMessage

class FirebaseNotifier {
    fun sendNotification(userToken: String, message: String) {
        val remoteMessage = RemoteMessage.Builder(userToken)
            .addData("alert", message)
            .build()

        FirebaseMessaging.getInstance().send(remoteMessage)
    }

}