package com.example.car_rental.network

import com.example.car_rental.NotifierInterface


//import software.amazon.awssdk.services.sns.SnsClient
//import software.amazon.awssdk.services.sns.model.PublishRequest

class AwsNotifier : NotifierInterface{
    override fun sendAlert(userToken: String, phoneNo: String, message: String) {
//        val snsClient = SnsClient.create()
//        val request = PublishRequest.builder()
//            .phoneNumber(phoneNumber)
//            .message(message)
//            .build()
//
//        snsClient.publish(request)
//        println("AWS Notification sent to rental company.")
    }

}