package com.example.photoapp.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.photoapp.adapter.ImageAdapter
import com.example.photoapp.databinding.ActivityMainBinding
import com.example.photoapp.repository.ImageRepository
import com.example.photoapp.viewmodel.ImageViewModel
import com.example.photoapp.viewmodel.ImageViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: ImageViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val repository = ImageRepository()

        val factory = ImageViewModelFactory(repository)

        viewModel = ViewModelProvider(this,factory)[ImageViewModel::class.java]

        binding.recyclerView.layoutManager = GridLayoutManager(this,2)

        viewModel.images.observe(this){imageList ->
            val adapter = ImageAdapter(imageList)
            binding.recyclerView.adapter = adapter
        }

        viewModel.fetchImages()


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finishAffinity()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}