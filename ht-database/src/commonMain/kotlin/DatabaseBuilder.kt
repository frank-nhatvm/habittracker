import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver

expect fun getDatabaseBuilder(): RoomDatabase.Builder<HTDatabase>

fun getRoomDatabase(builder: RoomDatabase.Builder<HTDatabase>): HTDatabase{
    return builder.setDriver(BundledSQLiteDriver()).build()
}