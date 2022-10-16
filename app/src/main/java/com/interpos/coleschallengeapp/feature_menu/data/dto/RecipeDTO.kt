package com.interpos.coleschallengeapp.feature_menu.data.dto

data class RecipeDTO(
    val dynamicDescription: String? = "",
    val dynamicThumbnail: String? = "",
    val dynamicThumbnailAlt: String? = "",
    val dynamicTitle: String? = "",
    val ingredients: List<IngredientDTO>,
    val recipeDetails: RecipeDetailsDTO
)