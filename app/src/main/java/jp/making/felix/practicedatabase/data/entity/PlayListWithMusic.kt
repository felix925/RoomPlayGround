package jp.making.felix.practicedatabase.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import jp.making.felix.practicedatabase.data.entity.Music
import jp.making.felix.practicedatabase.data.entity.PlayList

@Entity(
    tableName = "playlist_with_music",
    primaryKeys = ["playlist_id_with", "music_id_with"],
    foreignKeys = [
        ForeignKey(
            entity = PlayList::class,
            parentColumns = ["list_id"],
            childColumns = ["playlist_id_with"]
        ),
        ForeignKey(
            entity = Music::class,
            parentColumns = ["music_id"],
            childColumns = ["music_id_with"]
        )
    ]
)
data class PlayListWithMusic(
    @ColumnInfo(name = "playlist_id_with")
    val playlistId: Int,
    @ColumnInfo(name = "music_id_with")
    val musicId: Int
)