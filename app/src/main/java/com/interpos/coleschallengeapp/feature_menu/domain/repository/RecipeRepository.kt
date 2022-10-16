package com.interpos.coleschallengeapp.feature_menu.domain.repository

import com.interpos.coleschallengeapp.feature_menu.domain.model.Recipe
import kotlinx.coroutines.flow.Flow

interface RecipeRepository {
    suspend fun getRecipesFromJson(json : String) : Flow<List<Recipe>>
}