package com.nanicky.mediaviewer.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.nanicky.mediaviewer.db.model.VideoDetails

@Dao
interface VideoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAll(posts: List<VideoDetails>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(post: VideoDetails)

    @Update
    fun update(post: VideoDetails)

    @Delete
    fun delete(post: VideoDetails)

    @Query("SELECT * FROM VideoDetails")
    fun findAllLiveData(): LiveData<List<VideoDetails>>

    @Query("SELECT * FROM VideoDetails")
    fun findAll(): List<VideoDetails>
}
