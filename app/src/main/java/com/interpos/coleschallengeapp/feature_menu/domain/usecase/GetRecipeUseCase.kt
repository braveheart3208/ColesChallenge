package com.interpos.coleschallengeapp.feature_menu.domain.usecase

import com.interpos.coleschallengeapp.feature_menu.domain.ResultInteractor
import com.interpos.coleschallengeapp.feature_menu.domain.model.Recipe
import com.interpos.coleschallengeapp.feature_menu.domain.repository.RecipeRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow

class GetRecipeUseCase(private val recipeRepository: RecipeRepository) :
    ResultInteractor<String, Flow<List<Recipe>>>() {
    override val dispatcher: CoroutineDispatcher = Dispatchers.IO

    override suspend fun doWork(params: String): Flow<List<Recipe>> = recipeRepository.getRecipesFromJson(params)
}