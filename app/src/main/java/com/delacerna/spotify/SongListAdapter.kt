package com.delacerna.spotify

/**
 * Created by Harold on 12/17/2017.
 */
import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast


class SongListAdapter(val songList: ArrayList<Song>, context: Context, val mainActivity: MainActivity) : RecyclerView.Adapter<SongListAdapter.ViewHolder>() {

    var mContext = context
    var allSongList: ArrayList<String> = ArrayList()

    companion object {
        val SONGLIST = "songList"
        val SONGPOS = "songPos"
    }
    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.song?.text = songList[position].spotifyTitle
        holder?.singer?.text = songList[position].spotifySinger
        holder?.album?.text = songList[position].spotifyAlbum
        holder?.linearView?.setOnClickListener {

            for (i in 0 until songList.size) {
                allSongList.add(songList[i].spotifyPath)
            }
            try {
                val fragment = SongFragment.newInstance(songList[position].spotifyTitle, songList[position].spotifyAlbum)
                mainActivity.supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragment1, fragment)
                        .addToBackStack(null)
                        .commit()
            }
            catch (e: Exception){
            Toast.makeText(mContext,"Wrong!", Toast.LENGTH_SHORT).show()
            }
            var intent = Intent(mContext, SongService::class.java)
            intent.putStringArrayListExtra(SONGLIST, allSongList)
            intent.putExtra(SONGPOS, position)
            mContext.startService(intent)


        }
    }


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.song_list_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return songList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        var song: TextView
        var singer: TextView
        var album: TextView

        var linearView: RelativeLayout? = null

        init {
            song = itemView.findViewById(R.id.txtSong)
            singer = itemView.findViewById(R.id.txtSinger)
            album = itemView.findViewById(R.id.txtAlbum)
            linearView = itemView.findViewById(R.id.linear1)


        }

    }

}