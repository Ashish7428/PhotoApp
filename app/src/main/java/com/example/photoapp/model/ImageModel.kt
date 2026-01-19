package com.example.photoapp.model

import com.google.gson.annotations.SerializedName

data class ImageModel(
    @SerializedName("id")
    val id: String,

    @SerializedName("author")
    val author: String,

    @SerializedName("download_url")
    val imageUrl: String
)
