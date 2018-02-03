package com.delacerna.spotify

import android.os.Parcel
import android.os.Parcelable


/**
 * Created by Harold on 12/17/2017.
 */

data class Song(val spotifyTitle: String, val spotifySinger: String, val spotifyAlbum: String, val spotifyPath: String): Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString())

    override fun writeToParcel(parcel: Parcel?, flags: Int) {
        parcel?.writeString(spotifyTitle)
        parcel?.writeString(spotifySinger)
        parcel?.writeString(spotifyAlbum)
        parcel?.writeString(spotifyPath)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Song> {
        override fun createFromParcel(parcel: Parcel): Song {
            return Song(parcel)
        }

        override fun newArray(size: Int): Array<Song?> {
            return arrayOfNulls(size)
        }
    }
}

