package com.example.photoapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.photoapp.repository.ImageRepository

class ImageViewModelFactory(private val repository: ImageRepository):ViewModelProvider.Factory {
    override fun <T: ViewModel> create(modelClass: Class<T>):T{
        if(modelClass.isAssignableFrom(ImageViewModel::class.java)){
            return ImageViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}