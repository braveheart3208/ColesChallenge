package com.interpos.coleschallengeapp.feature_menu.domain.model

data class Recipe (
    val title : String,
    val description : String,
    val thumbnailUrl : String,
    val detail : RecipeDetail,
    val ingredients : List<Ingredient>
)