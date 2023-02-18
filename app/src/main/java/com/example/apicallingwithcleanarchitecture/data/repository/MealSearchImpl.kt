package com.example.apicallingwithcleanarchitecture.data.repository

import com.example.apicallingwithcleanarchitecture.data.model.MealsDTO
import com.example.apicallingwithcleanarchitecture.data.remote.MealSearchApi
import com.example.apicallingwithcleanarchitecture.domain.repository.MealSearchRepository

class MealSearchImpl(private val mealSearchApi: MealSearchApi): MealSearchRepository {
    override suspend fun getMealSearch(s: String): MealsDTO {
        return mealSearchApi.getSearchMealList(s)
    }
}