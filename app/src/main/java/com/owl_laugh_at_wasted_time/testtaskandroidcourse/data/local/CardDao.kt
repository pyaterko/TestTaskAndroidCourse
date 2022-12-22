package com.owl_laugh_at_wasted_time.testtaskandroidcourse.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.owl_laugh_at_wasted_time.testtaskandroidcourse.domain.constants.DATA_BASE_TABLE
import kotlinx.coroutines.flow.Flow

@Dao
interface CardDao {
    @Query("SELECT * FROM $DATA_BASE_TABLE")
    fun getAllData(): Flow<List<CardItemDbModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun add(item: CardItemDbModel)
}