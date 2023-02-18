package com.example.apicallingwithcleanarchitecture.domain.useCase

import com.example.apicallingwithcleanarchitecture.common.Resource
import com.example.apicallingwithcleanarchitecture.data.model.toDomainMeal
import com.example.apicallingwithcleanarchitecture.domain.model.Meal
import com.example.apicallingwithcleanarchitecture.domain.repository.MealSearchRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetMealSearchList @Inject constructor(private val mealSearchRepository: MealSearchRepository) {

    operator fun invoke(s: String): Flow<Resource<List<Meal>>> = flow {
        try {

            emit(Resource.Loading())
            val response = mealSearchRepository.getMealSearch(s)

            val list = if (response.meals.isNullOrEmpty()){
                emptyList<Meal>()
            }else {
                response.meals.map { it.toDomainMeal() }
            }

            emit(Resource.Success(data = list))
        }catch (e: HttpException){
            emit(Resource.Error(message = e.localizedMessage?:"Unknown error"))
        } catch (e: IOException){
            emit(Resource.Error(message = e.localizedMessage?:"PLease check your internet connection"))
        } catch (e: Exception){
            emit(Resource.Error(message = e.localizedMessage?:""))
        }

    }
}