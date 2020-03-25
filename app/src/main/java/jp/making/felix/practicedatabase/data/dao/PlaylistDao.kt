package jp.making.felix.practicedatabase.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import jp.making.felix.practicedatabase.data.entity.Music
import jp.making.felix.practicedatabase.data.entity.PlayList

@Dao
interface PlaylistDao {
    @Query("SELECT * FROM playlist")
    fun getAllPlaylist(): List<PlayList>

    @Insert
    fun insertPlayList(vararg playlist: PlayList)

    @Insert
    fun insertMusic(vararg music: Music)

    @Delete
    fun deletePlayList(playlist: PlayList)
    @Delete
    fun deleteMusic(music: Music)
}