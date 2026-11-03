package daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import entities.HabitEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface HabitDao {
    @Query("select * from habits")
    fun getAllHabits(): Flow<List<HabitEntity>>

    @Insert
    suspend fun insertHabit(habitEntity: HabitEntity)
}