package com.example.photoapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.photoapp.model.ImageModel
import com.example.photoapp.repository.ImageRepository
import kotlinx.coroutines.launch

class ImageViewModel(private val repository: ImageRepository):ViewModel() {
    private val _images = MutableLiveData<List<ImageModel>>()
    val images:LiveData<List<ImageModel>> = _images

    fun fetchImages(){
        viewModelScope.launch {
            val response = repository.getImages()
            _images.postValue(response)
        }
    }
}