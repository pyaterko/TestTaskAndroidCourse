package com.owl_laugh_at_wasted_time.testtaskandroidcourse.ui.base

import android.content.Context
import com.owl_laugh_at_wasted_time.testtaskandroidcourse.R

fun getStringOfBoolean(context:Context, prepaid:Boolean)=
    if (prepaid) context.getString(R.string.yes) else context.getString(R.string.no)