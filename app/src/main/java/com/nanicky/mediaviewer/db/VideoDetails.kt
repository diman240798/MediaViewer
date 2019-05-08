package com.nanicky.mediaviewer.db

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class VideoDetails(
        @PrimaryKey()
        val videoPath: String,
        var videoThumbNail: Bitmap?,
        val name: String,
        val dateTaken: Date,
        val dateModified: Date,
        val dateAdded: Date,
        val resolution: String,
        val mimeType: String
) {

}
