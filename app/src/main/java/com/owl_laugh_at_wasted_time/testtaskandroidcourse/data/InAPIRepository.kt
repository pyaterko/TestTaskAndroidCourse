package com.owl_laugh_at_wasted_time.testtaskandroidcourse.data

import com.owl_laugh_at_wasted_time.testtaskandroidcourse.data.local.CardDao
import com.owl_laugh_at_wasted_time.testtaskandroidcourse.data.local.CardItemDbModel
import com.owl_laugh_at_wasted_time.testtaskandroidcourse.domain.entity.CardItem
import com.owl_laugh_at_wasted_time.testtaskandroidcourse.domain.repository.APIRepository
import com.owl_laugh_at_wasted_time.testtaskandroidcourse.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class InAPIRepository @Inject constructor(
    private val apiWorker: APIRepository,
    private val cardDao: CardDao
) : Repository {

    override suspend fun getData(bin: String) = apiWorker.getData(bin)

    override suspend fun addToDatabase(item: CardItem) {
        cardDao.add(CardItemDbModel.toCardItemDbMogel(item))
    }

    override fun getAllData(): Flow<List<CardItem>> {
        val list = cardDao.getAllData()
        return list.map { listItemDbModel -> listItemDbModel.map { it.toCardItem() } }
    }


}
