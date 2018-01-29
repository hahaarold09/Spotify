package com.delacerna.spotify

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder

/**
 * Created by Harold on 1/26/2018.
 */

class SongService : Service() {


    var currentPos: Int = 0
    var songDataList: ArrayList<String> = ArrayList()
    var mediaPlay: MediaPlayer? = null

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        currentPos = intent!!.getIntExtra(SongListAdapter.SONGPOS, 0)
        songDataList = intent.getStringArrayListExtra(SongListAdapter.SONGLIST)

        if (mediaPlay != null) {
            mediaPlay!!.stop()
            mediaPlay!!.release()
            mediaPlay = null

        }
        mediaPlay = MediaPlayer()
        mediaPlay!!.setDataSource(songDataList[currentPos])
        mediaPlay!!.prepare()
        mediaPlay!!.setOnPreparedListener {
            mediaPlay!!.start()

        }

        return super.onStartCommand(intent, flags, startId)
    }

    fun pauseSong() {
        mediaPlay!!.pause()

    }

    fun playSong() {
        mediaPlay!!.start()


    }

}