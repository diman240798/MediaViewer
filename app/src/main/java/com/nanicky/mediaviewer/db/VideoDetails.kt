package com.nanicky.mediaviewer.db

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import java.util.*

@Entity(tableName = "VideoDetails")
@TypeConverters(DateConverter::class)
data class VideoDetails(
        @PrimaryKey()
        var path: String,
        @Ignore
        var thumb: Bitmap?,
        var name: String,
        var dateTaken: Date,
        var dateModified: Date,
        var dateAdded: Date,
        var resolution: String,
        var duration: String,
        var mimeType: String
) {
    constructor() : this("", null, "",
            Date(), Date(), Date(),
            "", "", "")

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as VideoDetails
        return this.path != other.path
    }
}
