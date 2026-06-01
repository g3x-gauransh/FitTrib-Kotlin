package com.example.fittrib.data

import Match
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface MatchDao {
    @Insert
    suspend fun insert(match: Match): Long

    @Update
    suspend fun update(match: Match)

    @Delete
    suspend fun delete(match: Match)

    @Query("SELECT * FROM matches WHERE user1Id = :userId OR user2Id = :userId")
    suspend fun getAllMatchesForUser(userId: String): List<Match>

    @Query("SELECT * FROM matches WHERE (user1Id = :userId OR user2Id = :userId) AND status = :status")
    suspend fun getMatchesByStatus(userId: String, status: String): List<Match>

    @Query("SELECT * FROM matches WHERE matchId = :matchId LIMIT 1")
    suspend fun getMatchById(matchId: Int): Match?

    @Query("SELECT * FROM matches WHERE ((user1Id = :user1Id AND user2Id = :user2Id) OR (user1Id = :user2Id AND user2Id = :user1Id)) LIMIT 1")
    suspend fun getMatchBetweenUsers(user1Id: String, user2Id: String): Match?

    @Query("UPDATE matches SET status = :status WHERE matchId = :matchId")
    suspend fun updateMatchStatus(matchId: Int, status: String)
}