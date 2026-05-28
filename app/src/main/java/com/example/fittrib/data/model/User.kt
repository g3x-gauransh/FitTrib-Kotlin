package com.example.fittrib.data.model;

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey
    val userId: String,
    val email: String,
    var displayName: String,
    var profilePictureUrl: String? = null,
    var fitnessGoal: String? = null,
    var experienceLevel: String? = null,
    var workoutPreferences: String? = null,
    var scheduleAvailability: String? = null,
    var city: String? = null,
    var state: String? = null,
    var latitude: Double = 0.0,
    var longitude: Double = 0.0,
    var age: Int = 0,
    var gender: String? = null,
    var bio: String? = null,
    val createdAt: Long = System.currentTimeMillis(),
    var updatedAt: Long = System.currentTimeMillis(),
    var isProfileComplete: Boolean = false
) {
    fun touch() {
        updatedAt = System.currentTimeMillis()
    }
}