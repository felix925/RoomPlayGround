package jp.making.felix.practicedatabase.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import jp.making.felix.practicedatabase.data.entity.Music
import jp.making.felix.practicedatabase.data.entity.PlayList
import jp.making.felix.practicedatabase.data.entity.PlayListWithMusic

@Dao
interface PlaylistWithMusicDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(playlistWithMusic: PlayListWithMusic)

    @Query("""
               SELECT * FROM playlist
               INNER JOIN playlist_with_music
               ON playlist.list_id=playlist_with_music.playlist_id_with
               WHERE playlist_with_music.music_id_with=:musicId
               """)
    fun getPlaylistsForSong(musicId: Int): Array<PlayList>

    @Query("""
               SELECT * FROM music
               INNER JOIN playlist_with_music
               ON music.music_id=playlist_with_music.music_id_with
               WHERE playlist_with_music.playlist_id_with=:playlistId
               """)
    fun getSongsForPlaylist(playlistId: Int): Array<Music>
}