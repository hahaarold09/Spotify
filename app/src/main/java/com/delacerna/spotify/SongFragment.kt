package com.delacerna.spotify

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


/**
 * A simple [Fragment] subclass.
 */
class SongFragment : Fragment(){

    private var mSong: TextView?=null
    private var mAlbum: TextView?=null
    companion object {
        fun newInstance(song:String, album:String): SongFragment{
            val args = Bundle()
            args.putString(Key.SONGTNAME,song)
            args.putString(Key.ALBUMNAME,album)
            val fragment = SongFragment()
            fragment.arguments = args
            return fragment
        }
    }
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val rootView = inflater?.inflate(R.layout.fragment_layout, container, false)
            mSong = rootView?.findViewById(R.id.txtfragment_song)
            mAlbum = rootView?.findViewById(R.id.txtfragment_album)
        val song = arguments.getString(Key.SONGTNAME)
        val album = arguments.getString(Key.ALBUMNAME)

        if(song != null && album != null) {
            mSong!!.text = song
            mAlbum!!.text = album
        }
        return rootView
    }

}
