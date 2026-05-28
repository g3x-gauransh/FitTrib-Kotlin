import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "trib_messages")
data class TribMessage(
    @PrimaryKey(autoGenerate = true)
    val messageId: Int = 0,
    val tribId: String,
    val senderId: String,
    val messageText: String,
    val timestamp: Long = System.currentTimeMillis(),
    val messageType: String = "text"
)