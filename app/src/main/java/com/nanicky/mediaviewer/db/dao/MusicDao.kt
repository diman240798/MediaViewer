package com.nanicky.mediaviewer.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.nanicky.mediaviewer.db.model.MusicDetails

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