package com.owl_laugh_at_wasted_time.testtaskandroidcourse.domain.repository

import com.owl_laugh_at_wasted_time.testtaskandroidcourse.domain.entity.CardItem
import com.owl_laugh_at_wasted_time.testtaskandroidcourse.domain.entity.cardinfo.CardInformation
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun getData(bin: String): CardInformation
    suspend fun addToDatabase(item: CardItem)
    fun getAllData(): Flow<List<CardItem>>
}