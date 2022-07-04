package com.example.imageapp.presentation.adapters

import android.text.TextUtils
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.imageapp.R
import com.example.imageapp.data.containers.Image
import com.example.imageapp.databinding.ItemImagesBinding

/**
 * A recyclerview adapter to show images
 * @author Sahil Salunke
 * @since 4/7/2022
 */
class ImagesAdapter(private val images: List<Image>) :
    RecyclerView.Adapter<ImagesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding: ItemImagesBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_images, parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val image: Image = images[position]
        holder.bind(image)
    }

    override fun getItemCount(): Int {
        return images.size
    }

    inner class ViewHolder(itemImagesBinding: ItemImagesBinding) :
        RecyclerView.ViewHolder(itemImagesBinding.root) {
        private var itemRowBindings: ItemImagesBinding = itemImagesBinding
        fun bind(obj: Image?) {
            if (obj != null && !TextUtils.isEmpty(obj.url)) {
                Glide.with(itemRowBindings.root).load(obj.url).into(itemRowBindings.imageView)
            }
            itemRowBindings.executePendingBindings()
        }
    }
}