package com.inditrade.graphql.data.api

import com.inditrade.movietestapp.data.model.MovieResponseModel
import retrofit2.Response
import retrofit2.http.GET


interface GraphQlService {
    companion object {
        const val BASE_URL = "https://twhiring-40b28.firebaseapp.com/"
    }

    @GET("interview_ios.json")
    suspend fun getMovies(): Response<MovieResponseModel>
}