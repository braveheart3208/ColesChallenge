package com.interpos.coleschallengeapp.feature_menu.data.repository

import com.interpos.coleschallengeapp.feature_menu.data.Converter
import com.interpos.coleschallengeapp.feature_menu.data.dto.RecipeDTO
import com.interpos.coleschallengeapp.feature_menu.domain.model.Ingredient
import com.interpos.coleschallengeapp.feature_menu.domain.model.Recipe
import com.interpos.coleschallengeapp.feature_menu.domain.model.RecipeDetail
import com.interpos.coleschallengeapp.feature_menu.domain.repository.RecipeRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RecipeRepositoryService(
    private val converter: Converter
) : RecipeRepository {

    private companion object {
        const val COLES_PREFIX_URL = "https://coles.com.au/"
    }

    @ExperimentalCoroutinesApi
    override suspend fun getRecipesFromJson(json: String): Flow<List<Recipe>> {
        if (json.isEmpty()) {
            return flow { }
        }
        return flow {
            val availableRecipes = mutableListOf<RecipeDTO>()
            //
            val availableRecipeDTO = converter.convertFromJSON(json)
            availableRecipeDTO?.let {
                availableRecipes.addAll(it.recipes)
            }
            //
            // !! because data objects will have the default value
            //
            emit(availableRecipes.map { recipeDTO ->
                Recipe(
                    title = recipeDTO.dynamicTitle!!,
                    description = recipeDTO.dynamicDescription!!,
                    thumbnailUrl = COLES_PREFIX_URL + recipeDTO.dynamicThumbnail,
                    detail = RecipeDetail(
                        amountLabel = recipeDTO.recipeDetails.amountLabel!!,
                        amountNumber = recipeDTO.recipeDetails.amountNumber!!,
                        cookingLabel = recipeDTO.recipeDetails.cookingLabel!!,
                        cookingTime = recipeDTO.recipeDetails.cookingTime!!,
                        prepLabel = recipeDTO.recipeDetails.prepLabel!!,
                        prepNote = recipeDTO.recipeDetails.prepNote!!,
                        prepTime = recipeDTO.recipeDetails.prepTime!!
                    ),
                    ingredients = recipeDTO.ingredients.map { ingredientDTO ->
                        Ingredient(
                            ingredient = ingredientDTO.ingredient!!
                        )
                    }
                )
            })
        }
    }
}