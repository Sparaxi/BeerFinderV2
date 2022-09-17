package com.example.beerfinderv2

import retrofit2.Response
import retrofit2.http.GET

// in this interface we write all the function we need to acces our api

interface TodoApi {

    @GET("/v2/beers")
   suspend fun getTodos(): Response<List<Todo>>
}