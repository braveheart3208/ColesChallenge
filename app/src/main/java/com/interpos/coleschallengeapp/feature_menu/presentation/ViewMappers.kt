package com.interpos.coleschallengeapp.feature_menu.presentation

import com.interpos.coleschallengeapp.feature_menu.domain.model.Recipe
import com.interpos.coleschallengeapp.feature_menu.presentation.model.DisplayRecipeGeneral

fun Recipe.toDisplayRecipeGeneral() : DisplayRecipeGeneral{
    return DisplayRecipeGeneral(
        title = this.title,
        description = this.description,
        thumbnailUrl = this.thumbnailUrl
    )
}