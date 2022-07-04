package com.example.imageapp.presentation.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.imageapp.R
import com.example.imageapp.databinding.ActivityMainBinding
import com.example.imageapp.presentation.adapters.ContentsAdapter
import com.example.imageapp.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * Main activity class for entire application
 * @author Sahil Salunke
 * @since 4/7/2022
 */
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    // Binder instance for home fragment
    private lateinit var binding: ActivityMainBinding

    // view model for this activity
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setContentView(binding.root)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)


        binding.progress.visibility = View.VISIBLE
        binding.rvMain.visibility = View.GONE

        viewModel.getImageData()

        setupObservers()

    }

    private fun setupObservers() {
        viewModel.contents.observe(this) {
            binding.progress.visibility = View.GONE
            binding.rvMain.visibility = View.VISIBLE
            val contentAdapter = it?.let { ContentsAdapter(it) }
            binding.adapter = contentAdapter
        }
    }

}