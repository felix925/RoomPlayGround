package jp.making.felix.practicedatabase.data.dao

import androidx.room.*
import jp.making.felix.practicedatabase.data.entity.Music
import jp.making.felix.practicedatabase.data.entity.PlayList

@Dao
interface PlaylistDao {
    @Query("SELECT * FROM playlist")
    fun getAllPlaylist(): List<PlayList>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPlayList(vararg playlist: PlayList)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMusic(vararg music: Music)

    @Delete
    fun deletePlayList(playlist: PlayList)
    @Delete
    fun deleteMusic(music: Music)
}