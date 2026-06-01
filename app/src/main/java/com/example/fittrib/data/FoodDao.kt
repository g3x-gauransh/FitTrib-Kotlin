import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface FoodDao {
    @Insert
    fun insertFood(food: Food?): Long

    @Insert
    fun insertFoods(foods: MutableList<Food?>?)

    @Update
    fun updateFood(food: Food?)

    @Delete
    fun deleteFood(food: Food?)

    @Query("SELECT * FROM foods ORDER BY foodName ASC")
    suspend fun getAllFoods(): List<Food>

    @Query("SELECT * FROM foods WHERE foodId = :foodId LIMIT 1")
    fun getFoodById(foodId: Int): Food?

    @Query("SELECT * FROM foods WHERE foodName LIKE '%' || :searchQuery || '%' ORDER BY foodName ASC")
    fun searchFoods(searchQuery: String?): MutableList<Food?>?

    @Query("SELECT * FROM foods WHERE category = :category ORDER BY foodName ASC")
    fun getFoodsByCategory(category: String?): MutableList<Food?>?

    @Insert
    fun insertFoodLog(logEntry: FoodLogEntry?): Long

    @Update
    fun updateFoodLog(logEntry: FoodLogEntry?)

    @Delete
    fun deleteFoodLog(logEntry: FoodLogEntry?)

    @Query("SELECT * FROM food_log WHERE userId = :userId AND logDate >= :startOfDay AND logDate <= :endOfDay ORDER BY logDate DESC")
    fun getFoodLogsForDay(
        userId: String?,
        startOfDay: Long,
        endOfDay: Long
    ): MutableList<FoodLogEntry?>?

    @Query("SELECT * FROM food_log WHERE userId = :userId ORDER BY logDate DESC LIMIT 50")
    fun getRecentFoodLogs(userId: String?): MutableList<FoodLogEntry?>?

    @Query("DELETE FROM food_log WHERE userId = :userId AND logDate >= :startOfDay AND logDate <= :endOfDay")
    fun clearLogsForDay(userId: String?, startOfDay: Long, endOfDay: Long)

}