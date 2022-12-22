package com.owl_laugh_at_wasted_time.testtaskandroidcourse.data.remote.api

import com.owl_laugh_at_wasted_time.testtaskandroidcourse.domain.repository.APIRepository
import javax.inject.Inject

class APIWorker @Inject constructor(
    private val api: APIService
) : APIRepository {
    override suspend fun getData(bin: String) = api.getData(bin)

}