package com.nanicky.mediaviewer.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MusicDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAll(posts: List<MusicDetails>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(post: MusicDetails)

    @Update
    fun update(post: MusicDetails)

    @Delete
    fun delete(post: MusicDetails)

    @Query("SELECT * FROM MusicDetails")
    fun findAll(): LiveData<List<MusicDetails>>
}