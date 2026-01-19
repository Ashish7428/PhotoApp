package com.example.photoapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.photoapp.R
import com.example.photoapp.databinding.ItemImageBinding
import com.example.photoapp.model.ImageModel

class ImageAdapter(private val imageList: List<ImageModel>):RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {
    inner class ImageViewHolder(val binding: ItemImageBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val binding = ItemImageBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ImageViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val imageItem = imageList[position]

        Glide.with(holder.itemView.context)
            .load(imageItem.imageUrl)
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.binding.imgPhoto)
    }


}