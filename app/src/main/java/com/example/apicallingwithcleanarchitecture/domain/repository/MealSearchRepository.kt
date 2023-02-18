package com.example.apicallingwithcleanarchitecture.domain.repository

import com.example.apicallingwithcleanarchitecture.data.model.MealsDTO

interface MealSearchRepository {
    suspend fun getMealSearch(s:String): MealsDTO
}