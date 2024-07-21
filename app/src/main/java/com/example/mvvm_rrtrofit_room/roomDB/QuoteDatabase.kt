package com.example.mvvm_rrtrofit_room.roomDB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mvvm_rrtrofit_room.models.Quote

@Database(entities = [Quote::class], version = 1)
abstract class QuoteDatabase : RoomDatabase() {

    abstract fun quoteDao(): QuoteDao

    companion object {

        private var INSTANCE: QuoteDatabase? = null

        fun getDatabAse(context: Context): QuoteDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE =
                        Room.databaseBuilder(
                            context,
                            QuoteDatabase::class.java,
                            "quoteDB"
                        ).build()
                }
            }
            return INSTANCE!!
        }
    }
}