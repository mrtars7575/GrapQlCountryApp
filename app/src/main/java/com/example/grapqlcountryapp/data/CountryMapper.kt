package com.example.grapqlcountryapp.data

import com.example.CountriesQuery
import com.example.CountryQuery
import com.example.grapqlcountryapp.domain.DetailedCountry
import com.example.grapqlcountryapp.domain.SimpleCountry

fun CountryQuery.Country.toDetailedCountry() : DetailedCountry {
    return DetailedCountry(
        code = code,
        capital = capital ?: "No capital",
        name = name,
        emoji = emoji,
        currency = currency ?: "No currency",
        languages = languages.mapNotNull { it.name },
        continent = continent.name

    )
}

fun CountriesQuery.Country.toSimpleCountry() : SimpleCountry {
    return SimpleCountry(
        code = code,
        capital = capital ?: "No capital",
        name = name,
        emoji = emoji,

    )
}