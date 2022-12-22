package com.owl_laugh_at_wasted_time.testtaskandroidcourse.domain.repository

import com.owl_laugh_at_wasted_time.testtaskandroidcourse.domain.entity.cardinfo.CardInformation

interface APIRepository {
    suspend fun getData(bin: String): CardInformation
}