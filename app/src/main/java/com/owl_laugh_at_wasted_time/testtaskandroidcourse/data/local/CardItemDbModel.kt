package com.owl_laugh_at_wasted_time.testtaskandroidcourse.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.owl_laugh_at_wasted_time.testtaskandroidcourse.domain.constants.DATA_BASE_TABLE
import com.owl_laugh_at_wasted_time.testtaskandroidcourse.domain.entity.CardItem

@Entity(tableName = DATA_BASE_TABLE)
data class CardItemDbModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val bin: String,
    val number_length: Int,
    val number_luhn: Boolean = false,
    val scheme: String,
    val type: String,
    val brand: String,
    val prepaid: Boolean = false,
    val country_name: String,
    val country_emoji: String,
    val country_latitude: Int,
    val country_longitude: Int,
    val bank_name: String,
    val bank_url: String,
    val bank_phone: String,
    val bank_city: String
) {
    fun toCardItem() = CardItem(
        id = id,
        bin = bin,
        number_length = number_length,
        number_luhn = number_luhn,
        scheme = scheme,
        type = type,
        brand = brand,
        prepaid = prepaid,
        country_name = country_name,
        country_emoji = country_emoji,
        country_latitude = country_latitude,
        country_longitude = country_longitude,
        bank_name = bank_name,
        bank_url = bank_url,
        bank_phone = bank_phone,
        bank_city = bank_city
    )

    companion object {
        fun toCardItemDbMogel(item: CardItem) = CardItemDbModel(
            id = item.id,
            bin = item.bin,
            number_length = item.number_length ?: 0,
            number_luhn = item.number_luhn ?: false,
            scheme = item.scheme ?: "",
            type = item.type ?: "",
            brand = item.brand ?: "",
            prepaid = item.prepaid ?: false,
            country_name = item.country_name ?: "",
            country_emoji = item.country_emoji ?: "",
            country_latitude = item.country_latitude ?: 0,
            country_longitude = item.country_longitude ?: 0,
            bank_name = item.bank_name ?: "",
            bank_url = item.bank_url ?: "",
            bank_phone = item.bank_phone ?: "",
            bank_city = item.bank_city ?: ""
        )
    }
}