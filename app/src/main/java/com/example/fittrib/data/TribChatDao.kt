package com.example.fittrib.data

import TribMessage
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TribChatDao {

    @Insert
    suspend fun insertMessage(message: TribMessage): Long

    @Query("SELECT * FROM trib_messages WHERE tribId = :tribId ORDER BY timestamp ASC")
    fun getTribMessagesFlow(tribId: String): Flow<List<TribMessage>>

    @Query("SELECT * FROM trib_messages WHERE tribId = :tribId ORDER BY timestamp DESC LIMIT 50")
    suspend fun getRecentTribMessages(tribId: String): List<TribMessage>
}