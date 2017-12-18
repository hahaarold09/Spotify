package com.delacerna.spotify

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by Harold on 12/16/2017.
 */
class SongFragment : Fragment() {

    private var songs: List<String>? = null
    private var albums: List<String>? = null
    private val PARTS_SONG = "parts_list"
    private val PARTS_ALBUM = "parts_number"

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        if (savedInstanceState != null) {
            songs = savedInstanceState.getStringArrayList(PARTS_SONG)
            albums = savedInstanceState.getStringArrayList(PARTS_ALBUM)

        }

        val rootView = inflater?.inflate(R.layout.fragment_song, container, false)
        return rootView
    }
}