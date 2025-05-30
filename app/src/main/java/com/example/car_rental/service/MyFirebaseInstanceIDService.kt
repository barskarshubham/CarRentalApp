package com.example.car_rental.service

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService

class MyFirebaseInstanceIDService : FirebaseMessagingService() {
    private var token: String = ""
    override fun onNewToken(token: String) {
        Log.d("FirebaseService", "Refreshed token: $token")
        this.token = token
        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // FCM registration token to your app server.
        //sendRegistrationToServer(token)
    }
    fun getToken(): String {
        return token
    }

}