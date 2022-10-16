package com.interpos.coleschallengeapp.feature_menu.di

import com.google.gson.GsonBuilder
import com.interpos.coleschallengeapp.feature_menu.data.Converter
import com.interpos.coleschallengeapp.feature_menu.data.repository.RecipeRepositoryService
import com.interpos.coleschallengeapp.feature_menu.data.util.GsonParser
import com.interpos.coleschallengeapp.feature_menu.data.util.JsonParser
import com.interpos.coleschallengeapp.feature_menu.domain.repository.RecipeRepository
import com.interpos.coleschallengeapp.feature_menu.domain.usecase.GetRecipeUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MenuRecipeModule {
    @Provides
    @Singleton
    fun provideGetRecipeUseCase(recipeRepository: RecipeRepository) =
        GetRecipeUseCase(recipeRepository)

    @Provides
    @Singleton
    fun provideRecipeRepository(converter: Converter): RecipeRepository =
        RecipeRepositoryService(converter)

    @Provides
    @Singleton
    fun provideConverter(jsonParser: JsonParser) = Converter(jsonParser)

    @Provides
    @Singleton
    fun provideJSONParser(): JsonParser = GsonParser(
        GsonBuilder()
            .setPrettyPrinting()
            .create()
    )
}