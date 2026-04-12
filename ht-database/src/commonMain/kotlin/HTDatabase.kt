import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import daos.HabitDao
import entities.HabitEntity

@Database(entities = [HabitEntity::class], version = 1)
@ConstructedBy(HTDatabaseConstructor::class)
abstract class HTDatabase : RoomDatabase() {
    abstract fun habitDao(): HabitDao
}

// The KSP processor will automatically generate this actual class
@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object HTDatabaseConstructor : RoomDatabaseConstructor<HTDatabase>