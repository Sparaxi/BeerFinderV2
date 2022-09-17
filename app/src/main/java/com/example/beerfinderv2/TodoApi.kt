package com.example.beerfinderv2

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

// in this interface we write all the functions we need to access our api

interface TodoApi {

    @GET("/v2/beers?page=1&per_page=5")
   suspend fun getTodos(): Response<List<Todo>>

    @GET("/v2/beers?beer_name={word}")
    suspend fun searchBeers(
        @Path("word") word: String
    ): List<Todo>
}