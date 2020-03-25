package jp.making.felix.practicedatabase.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PlayList(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "list_id")
    val playListId: Int,
    @ColumnInfo(name = "list_name")
    val playListName: String
)