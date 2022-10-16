package com.interpos.coleschallengeapp.feature_menu.presentation.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.interpos.coleschallengeapp.application.share.observeNonNull
import com.interpos.coleschallengeapp.databinding.FragmentMenuRecipeBinding
import com.interpos.coleschallengeapp.feature_menu.presentation.model.DisplayRecipeGeneral
import com.interpos.coleschallengeapp.feature_menu.presentation.util.Utils
import com.interpos.coleschallengeapp.feature_menu.presentation.view.adapter.RecipesAdapter
import com.interpos.coleschallengeapp.feature_menu.presentation.viewmodel.MenuViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MenuRecipeFragment : Fragment() {

    private val viewModel: MenuViewModel by viewModels()

    private lateinit var navigationController: NavController

    private var _binding: FragmentMenuRecipeBinding? = null
    private val binding get() = _binding!!

    private lateinit var recipeAdapter: RecipesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentMenuRecipeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigationController = Navigation.findNavController(view)
        //Set Up Adapter
        setUpAdapter()
        //Retrieve the json data content from Assets
        viewModel.onReceivedContentFromJsonFile(
            Utils.getJsonFromAssets(
                this.requireContext(),
                "recipesSample.json"
            )
        )
        //Set up all of the use-cases when load up view with ViewModel
        setUpObservers()
    }

    private fun setUpObservers() {
        observeNonNull(viewModel.loading, ::onLoadingStateChanged)
        observeNonNull(viewModel.availableRecipes, ::onRecipeListChanged)
    }

    private fun onLoadingStateChanged(isLoading: Boolean) {
        if (isLoading) {
            binding.loadingProgressBar.visibility = View.VISIBLE
            return
        }
        binding.loadingProgressBar.visibility = View.GONE
    }

    private fun onRecipeListChanged(updatedRecipeList: List<DisplayRecipeGeneral>) {
        recipeAdapter.setRecipes(updatedRecipeList)
    }

    private fun setUpAdapter() {
        recipeAdapter = RecipesAdapter(object : RecipesAdapter.OnRecipeClickedListener {
            override fun onRecipeClicked(recipe: DisplayRecipeGeneral) {
                //For 2nd-part of Screen - Details of Recipe
                Toast.makeText(requireContext(), recipe.title, Toast.LENGTH_LONG).show()
            }
        })
        binding.recipeRecyclerView.apply {
            adapter = recipeAdapter
            layoutManager = GridLayoutManager(this@MenuRecipeFragment.requireContext(), 2)
        }
    }
}