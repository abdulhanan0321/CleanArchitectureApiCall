package com.example.apicallingwithcleanarchitecture.data.remote

import com.example.apicallingwithcleanarchitecture.data.model.MealsDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface MealSearchApi {

    @GET("api/json/v1/1/search.php")
    suspend fun getSearchMealList(@Query("s") query: String): MealsDTO
}