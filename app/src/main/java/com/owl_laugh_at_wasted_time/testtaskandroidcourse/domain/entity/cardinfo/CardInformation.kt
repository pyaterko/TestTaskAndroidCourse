package com.owl_laugh_at_wasted_time.testtaskandroidcourse.domain.entity.cardinfo

data class CardInformation(
    val bank: Bank,
    val brand: String,
    val country: Country,
    val number: Number,
    val prepaid: Boolean,
    val scheme: String,
    val type: String
)