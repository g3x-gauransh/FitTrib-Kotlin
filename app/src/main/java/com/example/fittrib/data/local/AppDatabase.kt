package com.example.fittrib.data.local

import ChatDao
import FoodDao
import UserDao
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.fittrib.data.MatchDao
import com.example.fittrib.data.MeasurementDao
import com.example.fittrib.data.TribChatDao
import com.example.fittrib.data.model.*

@Database(
    entities = [
        User::class,
        BodyMeasurement::class,
        Food::class,
        FoodLogEntry::class,
        Match::class,
        Trib::class,
        ChatMessage::class,
        TribMessage::class
    ],
    version = 2,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun measurementDao(): MeasurementDao
    abstract fun foodDao(): FoodDao
    abstract fun matchDao(): MatchDao
    abstract fun chatDao(): ChatDao
    abstract fun tribChatDao(): TribChatDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "fittrib_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { INSTANCE = it }
            }
        }
    }
}