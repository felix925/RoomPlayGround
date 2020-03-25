package jp.making.felix.practicedatabase.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Music(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "music_id")
    val musicId: Int,
    @ColumnInfo(name = "music_name")
    val musicName: String
)