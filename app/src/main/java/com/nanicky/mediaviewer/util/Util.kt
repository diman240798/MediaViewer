package com.nanicky.mediaviewer.util

import android.content.Context
import android.provider.MediaStore
import com.nanicky.mediaviewer.db.MusicDetails
import com.nanicky.mediaviewer.db.VideoDetails
import java.util.*
import kotlin.collections.ArrayList

fun getAllVideo(context: Context?): ArrayList<VideoDetails> {
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

            val currentDetail = Array<String>(7) { "" }

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

            val videoThumbNail = null
            val element = VideoDetails(path, videoThumbNail, name, dateAdded, dateTaken, dateModified, resolution, mimeType)
            result.add(element)

        } while (cursor.moveToNext())

        cursor.close()
    } catch (e: Exception) {
        e.printStackTrace()
    }

    return result
}

fun getAllMusic(context: Context?): ArrayList<MusicDetails> {
    val result = ArrayList<MusicDetails>()

    val projection = arrayOf(
            MediaStore.Audio.Media.DATA,
            MediaStore.Audio.Media.DISPLAY_NAME,
            MediaStore.Audio.Media.DATE_ADDED,
            MediaStore.Audio.Media.DATE_MODIFIED,
            MediaStore.Audio.Media.ALBUM,
            MediaStore.Audio.Media.ARTIST,
            MediaStore.Audio.Media.COMPOSER,
            MediaStore.Audio.Media.MIME_TYPE
    )

    val cursor =
            context?.contentResolver?.query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, projection, null, null, null)
    try {
        cursor!!.moveToFirst()
        do {

            val currentDetail = Array<String>(7) { "" }

            for (i in 0..projection.size) {
                currentDetail[i] = cursor.getString(cursor.getColumnIndexOrThrow(projection[i]))
            }

            val path = currentDetail[0]
            val name = currentDetail[1]
            val dateAdded = Date(currentDetail[2])
            val dateModified = Date(currentDetail[3])
            val album = currentDetail[4]
            val artist = currentDetail[5]
            val composer = currentDetail[6]
            val mimeType = currentDetail[7]

            val musicThumbNail = null
            val element = MusicDetails(path, musicThumbNail, name, dateAdded, dateModified, album, artist, composer, mimeType)
            result.add(element)

        } while (cursor.moveToNext())

        cursor.close()
    } catch (e: Exception) {
        e.printStackTrace()
    }

    return result
}
