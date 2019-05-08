package com.nanicky.mediaviewer.db

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class MusicDetails(
        @PrimaryKey()
        val videoPath: String,
        var musicThumbNail: Bitmap?,
        val name: String,
        val dateAdded: Date,
        val dateModified: Date,
        val album: String,
        val artist: String,
        val composer: String,
        val mimeType: String
) {

}
