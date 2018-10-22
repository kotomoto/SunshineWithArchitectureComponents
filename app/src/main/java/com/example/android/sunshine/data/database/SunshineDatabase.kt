package com.example.android.sunshine.data.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import android.content.Context

@Database(entities = arrayOf(WeatherEntry::class), version = 1)
@TypeConverters(DateConverter::class)
abstract class SunshineDatabase : RoomDatabase() {
    abstract fun weatherDao(): WeatherDao

    companion object {
        var instance: SunshineDatabase? = null
        const val DATABASE_NAME = "weather"

        fun getSunshineDatabase(context: Context): SunshineDatabase? {
            if (instance == null) {
                synchronized(SunshineDatabase::class) {
                    instance = Room.databaseBuilder(context.applicationContext,
                            SunshineDatabase::class.java, DATABASE_NAME)
                            .build()
                }
            }

            return instance
        }
    }
}