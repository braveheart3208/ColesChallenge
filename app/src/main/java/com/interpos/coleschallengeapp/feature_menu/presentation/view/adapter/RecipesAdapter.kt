package com.interpos.coleschallengeapp.feature_menu.presentation.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.interpos.coleschallengeapp.R
import com.interpos.coleschallengeapp.databinding.LayoutRecipesBinding
import com.interpos.coleschallengeapp.feature_menu.presentation.model.DisplayRecipeGeneral

class RecipesAdapter(private val onRecipeClickedListener: OnRecipeClickedListener) :
    RecyclerView.Adapter<RecipesAdapter.ViewHolder>() {

    private val recipes = mutableListOf<DisplayRecipeGeneral>()

    @SuppressLint("NotifyDataSetChanged")
    fun setRecipes(updatedRecipes: List<DisplayRecipeGeneral>) {
        recipes.clear()
        recipes.addAll(updatedRecipes)
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: LayoutRecipesBinding) :
        RecyclerView.ViewHolder(binding.root),
        CleanableViewGroup {

        fun bind(recipe: DisplayRecipeGeneral) {
            binding.recipeImageView.load(recipe.thumbnailUrl) {
                placeholder(R.drawable.ic_coles)
            }
            binding.recipeTitleTextView.text = recipe.title
            binding.recipeDescriptionTextView.text = recipe.description

            itemView.setOnClickListener {
                onRecipeClickedListener.onRecipeClicked(recipe)
            }
        }

        override fun onCleanUp() {
            binding.root.removeAllViews()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutRecipesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onViewRecycled(holder: ViewHolder) {
        super.onViewRecycled(holder)
        holder.onCleanUp()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(recipes[position])
    }

    override fun getItemCount(): Int {
        return recipes.size
    }

    //To Clean Up all View
    interface CleanableViewGroup {
        fun onCleanUp()
    }

    interface OnRecipeClickedListener {
        fun onRecipeClicked(recipe: DisplayRecipeGeneral)
    }

}