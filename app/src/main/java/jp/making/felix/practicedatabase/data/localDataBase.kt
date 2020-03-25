package jp.making.felix.practicedatabase.data

import androidx.room.Database
import androidx.room.RoomDatabase
import jp.making.felix.practicedatabase.data.dao.PlaylistDao
import jp.making.felix.practicedatabase.data.dao.PlaylistWithMusicDao
import jp.making.felix.practicedatabase.data.entity.Music
import jp.making.felix.practicedatabase.data.entity.PlayList
import jp.making.felix.practicedatabase.data.entity.PlayListWithMusic

@Database(entities = [
    Music::class,
    PlayList::class,
    PlayListWithMusic::class
    ],
    version = 1
)
abstract class localDataBase: RoomDatabase(){
    abstract fun playlistWithMusicDao(): PlaylistWithMusicDao
    abstract fun playlistDao(): PlaylistDao
}