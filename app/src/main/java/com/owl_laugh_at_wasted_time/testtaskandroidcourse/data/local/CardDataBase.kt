package com.owl_laugh_at_wasted_time.testtaskandroidcourse.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CardItemDbModel::class], version = 1, exportSchema = false)
abstract class CardDataBase : RoomDatabase() {
    abstract fun cardDao(): CardDao
}