import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "foods")
data class Food(
    @PrimaryKey(autoGenerate = true)
    val foodId: Int = 0,
    val foodName: String,
    val calories: Int,
    val protein: Float,
    val carbs: Float,
    val fats: Float,
    val servingSize: String,
    val category: String? = null
)