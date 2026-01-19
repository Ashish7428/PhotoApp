package com.example.photoapp.repository

import com.example.photoapp.model.ImageModel
import com.example.photoapp.network.RetrofitInstance

class ImageRepository {
    suspend fun getImages():List<ImageModel>{
        return RetrofitInstance.api.getImages()
    }

}