import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tribs")
data class Trib(
    @PrimaryKey
    val tribId: String,
    val creatorId: String,
    val createdAt: Long = System.currentTimeMillis(),
    var tribName: String,
    var description: String? = null,
    var fitnessGoal: String? = null,
    var location: String? = null,
    var memberCount: Int = 1
)