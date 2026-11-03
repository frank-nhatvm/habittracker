import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import daos.HabitDao
import entities.HabitEntity

/**
 * Provides an abstract base for the Room-managed database that holds all habit-related entities.
 */
@Database(entities = [HabitEntity::class], version = 1)
@ConstructedBy(HTDatabaseConstructor::class)
abstract class HTDatabase : RoomDatabase() {

    /**
     * Retrieves the data access object for performing habit-related database operations.
     *
     * @return The HabitDao implementation provided by the Room code generator.
     */
    abstract fun habitDao(): HabitDao
}

// The KSP processor will automatically generate this actual class
/**
 * Provides a singleton implementation of the RoomDatabaseConstructor for HTDatabase.
 */
@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object HTDatabaseConstructor : RoomDatabaseConstructor<HTDatabase>