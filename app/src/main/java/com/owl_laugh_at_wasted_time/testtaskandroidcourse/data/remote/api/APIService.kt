package com.owl_laugh_at_wasted_time.testtaskandroidcourse.data.remote.api

import com.owl_laugh_at_wasted_time.testtaskandroidcourse.domain.entity.cardinfo.CardInformation
import retrofit2.http.GET
import retrofit2.http.Path

interface APIService {
    @GET("{bin}")
    suspend fun getData(@Path("bin") bin: String): CardInformation
}