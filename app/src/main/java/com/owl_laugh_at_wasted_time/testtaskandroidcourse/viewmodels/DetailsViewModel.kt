package com.owl_laugh_at_wasted_time.testtaskandroidcourse.viewmodels

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class DetailsViewModel @Inject constructor() : ViewModel() {

     fun openMap(context: Context, lat: Int?, lon: Int?) {
        val intent = Intent(Intent.ACTION_VIEW)
        if (lat != null && lon != null) {
            intent.data = Uri.parse("geo:${lat},${lon}")
            context.startActivity(intent)
        }
    }

     fun openDialPad(context: Context, phoneNum: String?) {
        phoneNum?.let {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:$it")
            context.startActivity(intent)
        }
    }

     fun openWebPage(context: Context, url: String?) {
        url?.let {
            var webpage = Uri.parse(url)
            if (!it.startsWith("http://") && !it.startsWith("https://")) {
                webpage = Uri.parse("http://$it")
            }
            val intent = Intent(Intent.ACTION_VIEW, webpage)
            context.startActivity(intent)
        }
    }
}