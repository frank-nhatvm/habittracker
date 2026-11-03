package entities

import androidx.room.Entity
import kotlinx.datetime.Instant

@Entity(tableName = "habits")
data class HabitEntity(
    val id: Long = 0,
    val type: Int,
    val name:String,
    val iconId: Int,
    val goal: String,
    val unit: String,
//    val createdAt: Instant
    )
