package com.interpos.coleschallengeapp.feature_menu.data

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.reflect.TypeToken
import com.interpos.coleschallengeapp.feature_menu.data.dto.RecipeDetailsDTO
import com.interpos.coleschallengeapp.feature_menu.data.dto.AvailableRecipesDTO
import com.interpos.coleschallengeapp.feature_menu.data.dto.IngredientDTO
import com.interpos.coleschallengeapp.feature_menu.data.util.JsonParser

@ProvidedTypeConverter
class Converter(
    private val jsonParser: JsonParser
) {
    fun convertFromJSON(json: String): AvailableRecipesDTO? {
        return jsonParser.fromJSON<AvailableRecipesDTO>(
            json = json,
            convertType = AvailableRecipesDTO::class.java
        )
    }

    @TypeConverter
    fun fromIngredientsJson(json: String): List<IngredientDTO> {
        return jsonParser.fromJSON<ArrayList<IngredientDTO>>(
            json = json,
            convertType = object : TypeToken<ArrayList<IngredientDTO>>() {}.type
        ) ?: emptyList()
    }

    @TypeConverter
    fun toIngredientsJson(ingredients: List<IngredientDTO>): String {
        return jsonParser.toJSON(
            convertingObject = ingredients,
            convertingType = object : TypeToken<ArrayList<IngredientDTO>>() {}.type
        ) ?: "[]"
    }

    @TypeConverter
    fun fromRecipeDetailJson(json: String): RecipeDetailsDTO? {
        return jsonParser.fromJSON<RecipeDetailsDTO>(
            json = json,
            convertType = RecipeDetailsDTO::class.java
        )
    }

    @TypeConverter
    fun toRecipeDetailJson(recipeDetail: RecipeDetailsDTO): String {
        return jsonParser.toJSON(
            convertingObject = recipeDetail,
            convertingType = RecipeDetailsDTO::class.java
        ) ?: ""
    }
}