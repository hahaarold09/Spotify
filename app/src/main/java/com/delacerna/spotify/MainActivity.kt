package com.delacerna.spotify

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.database.Cursor
import android.os.Bundle
import android.provider.MediaStore
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import android.support.design.widget.BottomNavigationView
import android.view.View
import android.widget.ImageView
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    var songData: ArrayList<Song> = ArrayList()
    var songListAdapter: SongListAdapter? = null

    private var tvPause: ImageView? = null
    private var tvPlay: ImageView? = null
    private var mySong = SongService()

    companion object {
        val REQUEST_CODE = 12
        var songName: TextView? = null
        var albumName: TextView? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViews()

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        BottomNavHelper.disableShiftMode(bottomNavigationView)

        if (ContextCompat.checkSelfPermission(applicationContext, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this@MainActivity,
                    arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE),
                    REQUEST_CODE)
        } else {
            loadData()
            songOnClick()
        }

    }

    private fun songOnClick() {
        tvPause?.setOnClickListener {
            tvPause?.visibility = View.INVISIBLE
            tvPlay?.visibility = View.VISIBLE
            mySong.pauseSong()
        }
        tvPlay?.setOnClickListener {
            tvPlay?.visibility = View.INVISIBLE
            tvPause?.visibility = View.VISIBLE
            mySong.playSong()
        }

    }

    private fun findViews() {
        tvPause = findViewById(R.id.btnPause)
        tvPlay = findViewById(R.id.btnPlay)
        songName = findViewById(R.id.txtfragment_song)
        albumName = findViewById(R.id.txtfragment_album)
    }


    @SuppressLint("Recycle")
    fun loadData() {
        val songCursor: Cursor? = contentResolver.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                null, null, null, null)
        while (songCursor != null && songCursor.moveToNext()) {
            var songTitle = songCursor.getString(songCursor.getColumnIndex(MediaStore.Audio.Media.TITLE))
            var songSinger = songCursor.getString(songCursor.getColumnIndex(MediaStore.Audio.Media.ARTIST))
            var songAlbum = songCursor.getString(songCursor.getColumnIndex(MediaStore.Audio.Media.ALBUM))
            var songPath = songCursor.getString(songCursor.getColumnIndex(MediaStore.Audio.Media.DATA))

            songData.add(Song(songTitle, songSinger, songAlbum, songPath))
        }
        songListAdapter = SongListAdapter(songData, applicationContext, mainActivity = MainActivity())
        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView1.layoutManager = layoutManager
        recyclerView1.adapter = songListAdapter
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (requestCode == REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                Toast.makeText(applicationContext, "Permission Granted", Toast.LENGTH_SHORT).show()
            loadData()
        }
    }

}

