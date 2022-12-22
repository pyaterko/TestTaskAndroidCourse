package com.owl_laugh_at_wasted_time.testtaskandroidcourse.domain.usecases

import com.owl_laugh_at_wasted_time.testtaskandroidcourse.domain.repository.Repository
import javax.inject.Inject

class RemoteDataUseCase @Inject constructor(private val repository: Repository) {
    suspend fun getData(bin: String) = repository.getData(bin)
}