package com.example.fittrib.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.fittrib.data.model.BodyMeasurement

@Dao
interface MeasurementDao {
    @Insert
    suspend fun insert(bodyMeasurement: BodyMeasurement): Long

    @Update
    suspend fun update(bodyMeasurement: BodyMeasurement)

    @Delete
    suspend fun delete(bodyMeasurement: BodyMeasurement)

    @Query("SELECT * FROM BodyMeasurement WHERE userId = :userId ORDER BY measurementDate DESC")
    suspend fun getAllMeasurementsByUser(userId: String): List<BodyMeasurement>

    @Query("SELECT * FROM BodyMeasurement WHERE userId = :id LIMIT 1")
    suspend fun getMeasurementById(id: Int): BodyMeasurement?

    @Query("SELECT * FROM BodyMeasurement WHERE userId = :userId ORDER BY measurementDate DESC LIMIT 1")
    suspend fun getLatestMeasurement(userId: String): BodyMeasurement?

    @Query("SELECT * FROM BodyMeasurement WHERE userId = :userId AND measurementDate BETWEEN :startDate AND :endDate ORDER BY measurementDate DESC")
    suspend fun getMeasurementsBetweenDates(userId: String, startDate: Long, endDate: Long): List<BodyMeasurement>

    @Query("SELECT * FROM BodyMeasurement WHERE userId = :userId ORDER BY measurementDate ASC LIMIT 1")
    suspend fun getFirstMeasurement(userId: String): BodyMeasurement?

    @Query("DELETE FROM BodyMeasurement WHERE userId = :userId")
    suspend fun deleteAllMeasurementsForUser(userId: String)

    @Query("SELECT COUNT(*) FROM bodymeasurement WHERE userId = :userId")
    suspend fun getMeasurementCount(userId: String): Int

    @Query("SELECT AVG(weight) FROM BodyMeasurement WHERE userId = :userId AND measurementDate >= :sinceDate")
    suspend fun getAverageWeightSince(userId: String, sinceDate: Long): Float


}