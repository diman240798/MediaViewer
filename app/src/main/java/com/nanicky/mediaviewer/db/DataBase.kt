package com.nanicky.mediaviewer.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nanicky.mediaviewer.db.MusicDao
import com.nanicky.mediaviewer.db.VideoDao
import com.nanicky.mediaviewer.db.VideoDetails

@Database(
        entities = arrayOf(VideoDetails::class, MusicDetails::class),
        version = 1)
abstract class DataBase : RoomDatabase() {
    abstract fun videoDao(): VideoDao
    abstract fun musicDao(): MusicDao
}
