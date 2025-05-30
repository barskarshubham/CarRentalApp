package com.example.car_rental.data

data class UserSpeedData(
    val userId: String,
    val currentSpeed: Double,
    val maxSpeed: Double,
) {
    fun isSpeedAboveLimit(): Boolean {
        return currentSpeed > maxSpeed
    }
}