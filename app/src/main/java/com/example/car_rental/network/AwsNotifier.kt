package com.example.car_rental.network
//import software.amazon.awssdk.services.sns.SnsClient
//import software.amazon.awssdk.services.sns.model.PublishRequest

class AwsNotifier {
    fun sendAlert(phoneNumber: String, message: String) {
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