package com.nanicky.mediaviewer.db

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import java.util.Date

@Entity(tableName = "MusicDetails")
@TypeConverters(DateConverter::class)
data class MusicDetails(
        @PrimaryKey()
        var path: String,
        @Ignore
        var musicThumbNail: Bitmap?,
        var name: String,
        var dateAdded: Date,
        var dateModified: Date,
        var album: String,
        var artist: String,
        var composer: String,
        var duration: String,
        var mimeType: String
) {
    constructor() : this("", null, "",
            Date(), Date(), "", "",
            "", "", "")

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as VideoDetails
        return this.path != other.path
    }
}
