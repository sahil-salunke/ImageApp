package com.example.imageapp.presentation.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.imageapp.R
import com.example.imageapp.data.containers.Content
import com.example.imageapp.databinding.ActivityMainBinding
import com.example.imageapp.presentation.State
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

    // Vertical item list adapter
    private lateinit var adapter: ContentsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setContentView(binding.root)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        viewModel.getImageData()

        setupRecyclerView()
        setupObservers()

    }

    private fun setupObservers() {
//        viewModel.contents.observe(this, Observer {
//            when (it) {
//                is State.DataState -> {
//                    binding.rvMain.adapter!!.notifyDataSetChanged()
//                }
//            }
//        })
    }

    private fun setupRecyclerView() {
        val contents = listOf<Content>()
        adapter = ContentsAdapter(contents)
        binding.rvMain.adapter = adapter

        viewModel.contents.observe(this) {
//            binding.progress.visibility = View.GONE
//            binding.rvHistoryCurrencies.visibility = View.VISIBLE
            val contentAdapter = viewModel.contents.value?.let { ContentsAdapter(it) }
            binding.adapter = contentAdapter
            binding.rvMain.adapter = adapter
        }

    }
}