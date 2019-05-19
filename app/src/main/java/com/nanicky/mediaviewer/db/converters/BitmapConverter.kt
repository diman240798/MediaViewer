package com.nanicky.mediaviewer.db.converters

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.room.TypeConverter
import java.io.ByteArrayOutputStream

object BitmapConverter {

    fun toBitmap(data: ByteArray): Bitmap = BitmapFactory
            .decodeByteArray(data, 0, data.size);

    fun fromBitmap(bitmap: Bitmap): ByteArray {
        val stream = ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        return stream.toByteArray()
    }
}
// @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
