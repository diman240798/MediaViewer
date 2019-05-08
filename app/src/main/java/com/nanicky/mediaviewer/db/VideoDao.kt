package com.nanicky.mediaviewer.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

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
    fun findAll(): LiveData<List<VideoDetails>>
}
