package com.juanegil.androidmaster.superheroapp

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("api/2355557887985158/search/{name}")
    suspend fun getSuperheroes(@Path("name") superheroName: String): Response<SuperheroDataResponse>

    @GET("api/2355557887985158/{id}")
    suspend fun getSuperheroDetail(@Path("id") superheroId: String): Response<SuperHeroDetailResponse>


}