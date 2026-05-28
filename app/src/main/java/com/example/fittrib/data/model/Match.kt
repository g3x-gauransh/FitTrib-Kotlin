import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "matches")
data class Match(
    @PrimaryKey(autoGenerate = true)
    val matchId: Int = 0,
    val user1Id: String,
    val user2Id: String,
    val compatibilityScore: Float,
    val status: String = "pending",
    val matchedAt: Long = System.currentTimeMillis()
)