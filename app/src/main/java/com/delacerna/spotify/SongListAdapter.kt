package com.delacerna.spotify

/**
 * Created by Harold on 12/17/2017.
 */


import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView


class SongListAdapter(val songList: ArrayList<Song>) : RecyclerView.Adapter<SongListAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.song?.text = songList[position].spotifyTitle
        holder?.singer?.text = songList[position].spotifySinger
        holder?.album?.text = songList[position].spotifyAlbum
        holder?.linearLayout?.setOnClickListener {

            holder.song.setTextColor(Color.parseColor("#1DB853"))


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

        val fragmentSong = itemView.findViewById<TextView>(R.id.txtfragment_song)
        val fragmentSinger = itemView.findViewById<TextView>(R.id.txtfragment_album)
        val song = itemView.findViewById<TextView>(R.id.txtSong)
        val singer = itemView.findViewById<TextView>(R.id.txtSinger)
        val album = itemView.findViewById<TextView>(R.id.txtAlbum)
        val linearLayout = itemView.findViewById<RelativeLayout>(R.id.linear1)


    }


}