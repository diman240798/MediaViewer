package com.nanicky.mediaviewer.db.converters

import androidx.room.TypeConverter

import java.util.Date

class DateConverter {

    @TypeConverter
    fun toDate(dateLong: Long): Date {
        return Date(dateLong)
    }

    @TypeConverter
    fun toDate(dateString: String?): Date {
        return Date(dateString)
    }

    @TypeConverter
    fun fromDate(date: Date): Long {
        return date.time
    }
}