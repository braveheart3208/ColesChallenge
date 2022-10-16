package com.interpos.coleschallengeapp.feature_menu.presentation.viewmodel

import androidx.lifecycle.*
import com.interpos.coleschallengeapp.feature_menu.domain.model.Recipe
import com.interpos.coleschallengeapp.feature_menu.domain.usecase.GetRecipeUseCase
import com.interpos.coleschallengeapp.feature_menu.presentation.model.DisplayRecipeGeneral
import com.interpos.coleschallengeapp.feature_menu.presentation.toDisplayRecipeGeneral
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor(
    private val getRecipeUseCase: GetRecipeUseCase
) : ViewModel() {

    private val _loading: MutableLiveData<Boolean> = MutableLiveData()
    val loading: LiveData<Boolean> = _loading

    lateinit var availableRecipes: LiveData<List<DisplayRecipeGeneral>>

    fun onReceivedContentFromJsonFile(jsonContent: String) {
        availableRecipes = liveData {
            getRecipeUseCase(jsonContent)
                .collect {
                    emitSafely(it.map { recipe ->
                        recipe.toDisplayRecipeGeneral()
                    })
                }
        }
    }

    private suspend fun <T> LiveDataScope<T>.emitSafely(data: T) =
        try {
            _loading.value = true
            emit(data)
            _loading.value = false

        } catch (ex: Exception) {
            // Exception handling here
            _loading.value = false
        }
}