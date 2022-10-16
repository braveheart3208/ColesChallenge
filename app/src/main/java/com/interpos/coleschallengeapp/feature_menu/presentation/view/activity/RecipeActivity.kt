package com.interpos.coleschallengeapp.feature_menu.presentation.view.activity

import android.os.Bundle
import com.interpos.coleschallengeapp.ColesActivity
import com.interpos.coleschallengeapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeActivity : ColesActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}