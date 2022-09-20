package com.example.beerfinderv2

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

// in this interface we write all the functions we need to access our api

interface PunkApi {

    @GET("/v2/beers")
   suspend fun getTodos(): Response<List<BeerDataStorage>>

    @GET("/v2/beers?beer_name={word}")
    suspend fun searchBeers(
        @Path("word") word: String
    ): List<BeerDataStorage>
}