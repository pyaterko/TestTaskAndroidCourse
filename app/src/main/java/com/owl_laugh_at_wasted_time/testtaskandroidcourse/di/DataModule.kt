package com.owl_laugh_at_wasted_time.testtaskandroidcourse.di

import android.content.Context
import androidx.room.Room
import com.owl_laugh_at_wasted_time.testtaskandroidcourse.data.local.CardDataBase
import com.owl_laugh_at_wasted_time.testtaskandroidcourse.domain.constants.DATA_BASE_NAME
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
interface DataModule {

    companion object {
        @Singleton
        @Provides
        fun provideDataBase(context: Context) =
            Room.databaseBuilder(
                context,
                CardDataBase::class.java,
                DATA_BASE_NAME
            )
                .fallbackToDestructiveMigration()
                .build()

        @Singleton
        @Provides
        fun provideDao(context: Context) = provideDataBase(context).cardDao()
    }
}

