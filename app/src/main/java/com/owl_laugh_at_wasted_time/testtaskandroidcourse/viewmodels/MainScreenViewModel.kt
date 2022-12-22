package com.owl_laugh_at_wasted_time.testtaskandroidcourse.viewmodels

import androidx.lifecycle.ViewModel
import com.owl_laugh_at_wasted_time.testtaskandroidcourse.domain.entity.CardItem
import com.owl_laugh_at_wasted_time.testtaskandroidcourse.domain.usecases.AddToDataBaseUseCase
import com.owl_laugh_at_wasted_time.testtaskandroidcourse.domain.usecases.GetAllDataUseCase
import com.owl_laugh_at_wasted_time.testtaskandroidcourse.domain.usecases.RemoteDataUseCase
import javax.inject.Inject

class MainScreenViewModel @Inject constructor(
    private val remoteDataUseCase: RemoteDataUseCase,
    private val addToDataBaseUseCase: AddToDataBaseUseCase,
    private val getAllDataUseCase: GetAllDataUseCase
) : ViewModel() {

    suspend fun getData(bin: String) = remoteDataUseCase.getData(bin)
    suspend fun add(item: CardItem) {
        addToDataBaseUseCase.addToDatabase(item)
    }

    fun  getAllData()=getAllDataUseCase.getAllData()

}