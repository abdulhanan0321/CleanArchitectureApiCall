package com.example.apicallingwithcleanarchitecture.presentation.mealSearch

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apicallingwithcleanarchitecture.common.Resource
import com.example.apicallingwithcleanarchitecture.domain.useCase.GetMealSearchList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MealSearchViewModel @Inject constructor(val getMealSearchList: GetMealSearchList): ViewModel() {


    private val _mealSearchList = MutableStateFlow<MealSearchState>(MealSearchState())
    val mealSearchList: StateFlow<MealSearchState> = _mealSearchList


    fun getSearchMeals(s: String) {
        getMealSearchList(s).onEach {
            when (it) {
                is Resource.Loading -> {
                    _mealSearchList.value = MealSearchState(isLoading = true)
                }
                is Resource.Success -> {
                    _mealSearchList.value = MealSearchState(data = it.data)
                }
                is Resource.Error -> {
                    _mealSearchList.value = MealSearchState(error = it.message ?: "")
                }
            }
        }.launchIn(viewModelScope)
    }


}