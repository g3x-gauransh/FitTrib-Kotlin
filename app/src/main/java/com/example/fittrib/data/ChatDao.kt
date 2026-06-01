import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ChatDao {

    @Insert
    suspend fun insertMessage(message: ChatMessage): Long

    @Query("""
        SELECT * FROM chat_messages 
        WHERE (senderId = :userId1 AND receiverId = :userId2) 
           OR (senderId = :userId2 AND receiverId = :userId1) 
        ORDER BY timestamp ASC
    """)
    fun getConversationFlow(userId1: String, userId2: String): Flow<List<ChatMessage>>

    @Query("UPDATE chat_messages SET isRead = 1 WHERE receiverId = :userId AND senderId = :otherUserId")
    suspend fun markMessagesAsRead(userId: String, otherUserId: String)  // Update once

    @Query("SELECT * FROM chat_messages WHERE receiverId = :userId AND isRead = 0")
    fun getUnreadMessagesFlow(userId: String): Flow<List<ChatMessage>>
    // Flow! Badge count updates in real-time
}