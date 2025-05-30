package com.example.car_rental.data
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore

private val TAG = FirestoreService::class.java.simpleName
object FirestoreService {

    private val db = FirebaseFirestore.getInstance()
    fun setSpeedLimit(userId: String, maxSpeed: Double) {
        val speedData = hashMapOf(
            "maxSpeed" to maxSpeed,
            "userId" to "RJ4749"
        )

        db.collection("userInfo")
            .add(speedData)
            .addOnSuccessListener { documentReference ->
                Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w(TAG, "Error adding document", e)
            }
    }


    fun getSpeedLimit(userId: String, callback: (Double?) -> Unit) {
        db.collection("userInfo").document(userId)
            .get()
            .addOnSuccessListener { document ->
                val maxSpeed = document.getDouble("maxSpeed")
                callback(maxSpeed)
            }
            .addOnFailureListener { e -> println("Error retrieving speed limit: $e") }
    }

}