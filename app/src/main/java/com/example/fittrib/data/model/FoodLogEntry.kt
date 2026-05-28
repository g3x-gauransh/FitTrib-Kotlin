import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "food_log")
data class FoodLogEntry(
    @PrimaryKey(autoGenerate = true)
    val logId: Int = 0,
    val userId: String,
    val foodId: Int,
    val logDate: Long = System.currentTimeMillis(),
    val servings: Float = 1.0f,
    val mealType: String? = null
)