package com.example.grapqlcountryapp.data

import com.apollographql.apollo3.ApolloClient
import com.example.CountriesQuery
import com.example.CountryQuery
import com.example.grapqlcountryapp.domain.CountryClient
import com.example.grapqlcountryapp.domain.DetailedCountry
import com.example.grapqlcountryapp.domain.SimpleCountry

class ApolloCountryClient (
    private val apolloClient : ApolloClient
)  : CountryClient{
    override suspend fun getCountries(): List<SimpleCountry> {
        return apolloClient
            .query(CountriesQuery())
            .execute()
            .data?.countries?.map{
                it.toSimpleCountry()
            } ?: emptyList()
    }

    override suspend fun getCountry(code: String): DetailedCountry? {
        return apolloClient
            .query(CountryQuery(code))
            .execute()
            .data?.country?.toDetailedCountry()
    }

}