package jp.making.felix.practicedatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room
import jp.making.felix.practicedatabase.data.entity.Music
import jp.making.felix.practicedatabase.data.entity.PlayList
import jp.making.felix.practicedatabase.data.entity.PlayListWithMusic
import jp.making.felix.practicedatabase.data.localDataBase
import jp.making.felix.practicedatabase.ui.main.MainFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var dataBase: localDataBase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow()
        }
        dataBase = Room.databaseBuilder(
            baseContext,
            localDataBase::class.java,
            "localDatabase"
        ).build()
        runBlocking(Dispatchers.IO){
            test()
        }
    }

    suspend fun test(){
        val id = UUID.randomUUID().variant()
        val music = Music(
            musicId = id,
            musicName = "HelloWorld"
        )
        val playlist = PlayList(
            playListId = id,
            playListName = "REOL"
        )
        val withTable = PlayListWithMusic(
            id,
            id
        )
        dataBase.let {
            it.playlistDao().insertMusic(music)
            it.playlistDao().insertPlayList(playlist)
            it.playlistWithMusicDao().insert(withTable)
            Log.d("mucic", it.playlistWithMusicDao().getPlaylistsForSong(id).toString())

        }
    }
}