package com.nanicky.mediaviewer.repo

import android.content.Context
import com.nanicky.mediaviewer.db.dao.VideoDao
import com.nanicky.mediaviewer.db.model.VideoDetails
import com.nanicky.mediaviewer.util.getVideoFromDevice

class VideoRepository(val videoDao: VideoDao) {
    suspend fun getAllVideos(context: Context): List<VideoDetails> {
        val videosFromDB = videoDao.findAll()
        if (!videosFromDB.isEmpty()) return videosFromDB

        val videosFromDevice = getVideoFromDevice(context)
        return videosFromDevice
    }
}
