package com.owl_laugh_at_wasted_time.testtaskandroidcourse.viewmodels

import androidx.lifecycle.ViewModel
import com.owl_laugh_at_wasted_time.testtaskandroidcourse.domain.usecases.GetAllDataUseCase
import javax.inject.Inject

class HistoryViewModel @Inject constructor(
    private val getAllDataUseCase: GetAllDataUseCase
) : ViewModel() {

    fun getData() = getAllDataUseCase.getAllData()
}