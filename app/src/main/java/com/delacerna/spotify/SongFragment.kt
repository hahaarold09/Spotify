package com.delacerna.spotify

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView



/**
 * A simple [Fragment] subclass.
 */
class SongFragment : Fragment(){
    private var fragmentSong: TextView?=null
    private var fragmentAlbum: TextView?=null
    private var fragmentDot: TextView?=null
    private var mUpArrow: ImageView?=null
    private var mPlay: ImageView?=null
    private var mPause: ImageView?=null


   class Key{
        companion object {
            var SONG = "song"
            var ALBUM = "album"
        }
    }
    companion object {

        fun newInstance (song :String, album: String) : SongFragment{
            val args = Bundle()
            args.putString(Key.SONG, song)
            args.putString(Key.ALBUM, album)
            val fragment = SongFragment()
            fragment.arguments = args
            return fragment

        }
    }
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var v = inflater!!.inflate(R.layout.fragment, container, false)
        fragmentSong = v.findViewById(R.id.txtfragment_song)
        fragmentAlbum = v.findViewById(R.id.txtfragment_album)
        fragmentDot = v.findViewById(R.id.txtfragment_center)



        var song = arguments.getString(Key.SONG)
        var album = arguments.getString(Key.ALBUM)

        if(song != null && album != null){
            fragmentSong?.text = song
            fragmentAlbum?.text = album
        }

        return v
    }




}
