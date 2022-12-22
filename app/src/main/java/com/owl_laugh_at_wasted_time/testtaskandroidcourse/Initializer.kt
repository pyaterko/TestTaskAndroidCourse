package com.owl_laugh_at_wasted_time.testtaskandroidcourse

import android.content.Context
import com.owl_laugh_at_wasted_time.testtaskandroidcourse.di.AppComponent
import com.owl_laugh_at_wasted_time.testtaskandroidcourse.di.DaggerAppComponent


object Initializer {
    fun component(context: Context): AppComponent {
        return DaggerAppComponent.factory().create(context)
    }
}