package com.nanicky.mediaviewer

import android.content.Context
import android.provider.MediaStore
import java.util.*
import kotlin.collections.ArrayList

fun getAllMedia(context: Context?): ArrayList<VideoDetails> {
    val result = ArrayList<VideoDetails>()

    val projection = arrayOf(
            MediaStore.Video.Media.DATA,
            MediaStore.Video.Media.DISPLAY_NAME,
            MediaStore.Video.Media.DATE_ADDED,
            MediaStore.Video.Media.DATE_TAKEN,
            MediaStore.Video.Media.DATE_MODIFIED,
            MediaStore.Video.Media.RESOLUTION,
            MediaStore.Video.Media.MIME_TYPE
    )
    val cursor =
            context?.contentResolver?.query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, projection, null, null, null)
    try {
        cursor!!.moveToFirst()
        do {

            val currentDetail = Array<String>(7, { "" })

            for (i in 0..projection.size) {
                currentDetail[i] = cursor.getString(cursor.getColumnIndexOrThrow(projection[i]))
            }

            val path = currentDetail[0]
            val name = currentDetail[1]
            val dateAdded = Date(currentDetail[2])
            val dateTaken = Date(currentDetail[3])
            val dateModified = Date(currentDetail[4])
            val resolution = currentDetail[5]
            val mimeType = currentDetail[6]

            val element = VideoDetails(path, name, dateAdded, dateTaken, dateModified, resolution, mimeType)
            result.add(element)

        } while (cursor.moveToNext())

        cursor.close()
    } catch (e: Exception) {
        e.printStackTrace()
    }

    val downloadedList = ArrayList(result)
    return downloadedList
}

fun getAllMusic(context: Context?): ArrayList<String> {
    val videoItemHashSet = HashSet<String>()
    val projection = arrayOf(MediaStore.Audio.AudioColumns.DATA, MediaStore.Audio.Media.DISPLAY_NAME)
    val cursor =
            context?.contentResolver?.query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, projection, null, null, null)
    try {
        cursor!!.moveToFirst()
        do {
            videoItemHashSet.add(cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Video.Media.DATA)))
        } while (cursor.moveToNext())

        cursor.close()
    } catch (e: Exception) {
        e.printStackTrace()
    }

    val downloadedList = ArrayList(videoItemHashSet)
    return downloadedList
}
