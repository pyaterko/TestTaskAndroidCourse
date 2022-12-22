package com.owl_laugh_at_wasted_time.testtaskandroidcourse.di

import android.content.Context
import com.owl_laugh_at_wasted_time.testtaskandroidcourse.MainActivity
import com.owl_laugh_at_wasted_time.testtaskandroidcourse.ui.fragments.DetailsFragment
import com.owl_laugh_at_wasted_time.testtaskandroidcourse.ui.fragments.MainScreenFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        RepositoryModule::class,
        ApiModule::class,
        ViewModelModule::class,
        DataModule::class
    ]
)
interface AppComponent {

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance applicationContext: Context
        ): AppComponent
    }

    fun context(): Context
    fun inject(activity: MainActivity)
    fun inject(fragment: MainScreenFragment)
    fun inject(fragment: DetailsFragment)

}