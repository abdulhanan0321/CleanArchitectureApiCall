package com.example.apicallingwithcleanarchitecture.hilt

import com.example.apicallingwithcleanarchitecture.common.Constants
import com.example.apicallingwithcleanarchitecture.data.remote.MealSearchApi
import com.example.apicallingwithcleanarchitecture.data.repository.MealSearchImpl
import com.example.apicallingwithcleanarchitecture.domain.repository.MealSearchRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HiltModules {

    @Provides
    @Singleton
    fun provideMealSearchAPI(): MealSearchApi {
        return Retrofit.Builder().baseUrl(Constants.BASEURL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(MealSearchApi::class.java)
    }


    @Provides
    fun provideMealSearchRepository(mealSearchAPI: MealSearchApi): MealSearchRepository {
        return MealSearchImpl(mealSearchAPI)
    }
}