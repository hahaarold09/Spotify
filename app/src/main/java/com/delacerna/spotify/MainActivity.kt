package com.delacerna.spotify

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv = findViewById<RecyclerView>(R.id.recyclerView1)
        rv.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        val users = ArrayList<Song>()

        users.add(Song("Titibo-Tibo", "Moria Dela Torre", " • Himig Handog 2017"))
        users.add(Song("Havana", "Camilla Cabello", " • Havana"))
        users.add(Song("Arms Open", "The Script", " • Human Clay"))
        users.add(Song("Look At Me Now", "Charlie Puth", " • Alien Boy"))
        users.add(Song("Where My Love Goes", "Lawson", " • Perspective"))
        users.add(Song("If You Could See Me Now", "The Script", " • 3"))
        users.add(Song("Back To You", "Louis Tomlinson", " • Louis Tomlinson"))
        users.add(Song("Sorry Not Sorry", "Demi Lovato", " • Tell Me You Love Me"))
        users.add(Song("Too Good At Goodbyes", "Sam Smith", " • The Thrill of It All"))
        users.add(Song("Perfect", "Ed Sheeran", " • Divide"))
        users.add(Song("What Lovers Do", "Maroon 5 ft. SZA", " • Red Pill Blues"))


        var adapter = SongListAdapter(users)
        rv.adapter = adapter



    }
}
