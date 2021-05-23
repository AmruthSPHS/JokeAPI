package com.example.jokeapi.services

import com.example.jokeapi.models.MyJoke
import retrofit2.Call
import retrofit2.http.GET

interface JokeService {

    @GET("random_ten")
    fun getAffectedJokeList () : Call<List<MyJoke>>
}