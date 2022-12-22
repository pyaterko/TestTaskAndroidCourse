package com.owl_laugh_at_wasted_time.testtaskandroidcourse.di

import com.owl_laugh_at_wasted_time.testtaskandroidcourse.data.InAPIRepository
import com.owl_laugh_at_wasted_time.testtaskandroidcourse.data.remote.api.APIWorker
import com.owl_laugh_at_wasted_time.testtaskandroidcourse.domain.repository.APIRepository
import com.owl_laugh_at_wasted_time.testtaskandroidcourse.domain.repository.Repository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface RepositoryModule {
    @Singleton
    @Binds
    fun bindAPIRepository(impl: APIWorker): APIRepository

    @Singleton
    @Binds
    fun bindRepository(impl: InAPIRepository): Repository
}