package com.example.grapqlcountryapp.domain

import com.example.CountryQuery

interface CountryClient {
    suspend fun getCountries() : List<SimpleCountry>
    suspend fun getCountry(code:String) : DetailedCountry?
}