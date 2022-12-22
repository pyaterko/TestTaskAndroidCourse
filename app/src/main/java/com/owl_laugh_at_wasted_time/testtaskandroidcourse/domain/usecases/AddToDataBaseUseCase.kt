package com.owl_laugh_at_wasted_time.testtaskandroidcourse.domain.usecases

import com.owl_laugh_at_wasted_time.testtaskandroidcourse.domain.entity.CardItem
import com.owl_laugh_at_wasted_time.testtaskandroidcourse.domain.repository.Repository
import javax.inject.Inject

class AddToDataBaseUseCase @Inject constructor(private val repository: Repository) {
    suspend fun addToDatabase(item: CardItem) {
        repository.addToDatabase(item)
    }
}