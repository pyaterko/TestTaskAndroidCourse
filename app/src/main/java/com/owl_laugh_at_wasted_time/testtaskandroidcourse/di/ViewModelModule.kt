package com.owl_laugh_at_wasted_time.testtaskandroidcourse.di

import androidx.lifecycle.ViewModel
import com.owl_laugh_at_wasted_time.testtaskandroidcourse.viewmodels.DetailsViewModel
import com.owl_laugh_at_wasted_time.testtaskandroidcourse.viewmodels.HistoryViewModel
import com.owl_laugh_at_wasted_time.testtaskandroidcourse.viewmodels.MainScreenViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainScreenViewModel::class)
    fun bindMainScreenViewModel(viewModel: MainScreenViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HistoryViewModel::class)
    fun bindHistoryViewModel(viewModel: HistoryViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailsViewModel::class)
    fun bindDetailsViewModel(viewModel: DetailsViewModel): ViewModel
}