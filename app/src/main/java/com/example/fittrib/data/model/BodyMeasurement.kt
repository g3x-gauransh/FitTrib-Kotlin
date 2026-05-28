package com.example.fittrib.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "BodyMeasurement")
data class BodyMeasurement(
    @PrimaryKey(autoGenerate = true)
    val fireStoreId : String,
    val userId : String,
    var measurementDate : Long = System.currentTimeMillis(),
    var weight : Float,
    var bodyFatPercentage : Float = 0f,
    var chest : Float = 0f,
    var waist : Float = 0f,
    var hips : Float = 0f,
    var leftArm : Float = 0f,
    var rightArm : Float = 0f,
    var leftThigh : Float = 0f,
    var rightThigh : Float = 0f,
    var leftCalf : Float = 0f,
    var rightCalf : Float = 0f,
    var shoulder : Float = 0f,
    var neck : Float = 0f,
    var notes : String? = null,
    var createdAt : Long = System.currentTimeMillis()
) {
}