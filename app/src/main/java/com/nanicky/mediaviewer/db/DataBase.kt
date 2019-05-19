package com.nanicky.mediaviewer.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nanicky.mediaviewer.db.dao.MusicDao
import com.nanicky.mediaviewer.db.dao.VideoDao
import com.nanicky.mediaviewer.db.model.MusicDetails
import com.nanicky.mediaviewer.db.model.VideoDetails

@Database(
        entities = arrayOf(VideoDetails::class, MusicDetails::class),
        version = 1)
abstract class DataBase : RoomDatabase() {
    abstract fun videoDao(): VideoDao
    abstract fun musicDao(): MusicDao

    companion object {
        var INSTANCE: DataBase? = null

        fun getAppDataBase(context: Context): DataBase? {
            if (INSTANCE == null){
                synchronized(DataBase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext, DataBase::class.java, "MediaDataBase").build()
                }
            }
            return INSTANCE
        }

        fun destroyDataBase(){
            INSTANCE = null
        }
    }
}
