package com.example.imageapp.presentation.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.imageapp.R
import com.example.imageapp.databinding.ActivityMainBinding
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

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setContentView(binding.root)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        viewModel.getImageData()


    }
}