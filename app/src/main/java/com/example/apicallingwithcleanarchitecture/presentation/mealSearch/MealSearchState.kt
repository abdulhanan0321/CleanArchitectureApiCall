package com.example.apicallingwithcleanarchitecture.presentation.mealSearch

import com.example.apicallingwithcleanarchitecture.domain.model.Meal

data class MealSearchState(
    val data: List<Meal>? = null,
    val error: String? = "",
    val isLoading: Boolean = false
) {
}