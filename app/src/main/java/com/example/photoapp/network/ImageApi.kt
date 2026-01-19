package com.example.photoapp.network

import com.example.photoapp.constants.Constants
import com.example.photoapp.model.ImageModel
import retrofit2.http.GET

interface ImageApi {
    @GET(Constants.ENDPOINT)
    suspend fun getImages():List<ImageModel>
}