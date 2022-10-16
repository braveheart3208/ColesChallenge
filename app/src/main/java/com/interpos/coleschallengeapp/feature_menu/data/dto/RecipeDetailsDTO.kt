package com.interpos.coleschallengeapp.feature_menu.data.dto

data class RecipeDetailsDTO(
    val amountLabel: String? = "",
    val amountNumber: Int? = 0,
    val cookTimeAsMinutes: Int? = 0,
    val cookingLabel: String? = "",
    val cookingTime: String? = "",
    val prepLabel: String? = "",
    val prepNote: String? = "",
    val prepTime: String? = "",
    val prepTimeAsMinutes: Int? = 0
)