package com.owl_laugh_at_wasted_time.testtaskandroidcourse.domain.entity

import android.os.Parcelable
import com.owl_laugh_at_wasted_time.testtaskandroidcourse.domain.constants.UNDEFINED_ID
import kotlinx.parcelize.Parcelize

@Parcelize
data class CardItem (
    val id:Int= UNDEFINED_ID,
    val bin:String="",
    val number_length:Int?=0,
    val number_luhn:Boolean?=false,
    val scheme:String?="",
    val type:String?="",
    val brand:String?="",
    val prepaid:Boolean?=false,
    val country_name:String?="",
    val country_emoji:String?="",
    val country_latitude:Int?=0,
    val country_longitude:Int?=0,
    val bank_name:String?="",
    val bank_url:String?="",
    val bank_phone:String?="",
    val bank_city:String?=""
):Parcelable