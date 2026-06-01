import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.fittrib.data.model.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: User)

    @Update
    suspend fun update(user: User)

    @Delete
    suspend fun delete(user: User)

    @Query("SELECT * FROM users WHERE userId = :userId LIMIT 1")
    suspend fun getUserById(userId: String): User?

    @Query("SELECT * FROM users WHERE email = :email LIMIT 1")
    suspend fun getUserByEmail(email: String): User?

    @Query("SELECT * FROM users")
    fun getAllUsersFlow(): Flow<List<User>>

    @Query("SELECT * FROM users WHERE isProfileComplete = 1")
    fun getAllCompleteProfilesFlow(): Flow<List<User>>

    @Query("SELECT * FROM users WHERE fitnessGoal = :goal")
    suspend fun getUserByGoal(goal: String): List<User>

    @Query("SELECT * FROM users WHERE experienceLevel = :level")
    suspend fun getUserByExperienceLevel(level: String): List<User>

    @Query("SELECT COUNT(*) FROM users")
    suspend fun getUserCount(): Int

    @Query("DELETE FROM users WHERE userId = :userId")
    fun deleteUserById(userId: String?)

    @Query("DELETE FROM users")
    fun deleteAllUsers()

    @Query("UPDATE users SET isProfileComplete = :isComplete WHERE userId = :userId")
    fun updateProfileCompletionStatus(userId: String?, isComplete: Boolean)

    @Query("UPDATE users SET profilePictureUrl = :url WHERE userId = :userId")
    fun updateProfilePicture(userId: String?, url: String?)

}