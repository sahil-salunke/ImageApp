package com.example.imageapp.presentation.adapters

import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import com.example.imageapp.R
import com.example.imageapp.data.containers.Content
import com.example.imageapp.databinding.AdapterContentsBinding

/**
 * A recyclerview adapter to show content data
 * @author Sahil Salunke
 * @since 4/7/2022
 */
class ContentsAdapter(private val contents: List<Content>) :
    RecyclerView.Adapter<ContentsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding: AdapterContentsBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.adapter_contents, parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val content: Content = contents[position]
        holder.bind(content)
    }

    override fun getItemCount(): Int {
        return contents.size
    }

    inner class ViewHolder(itemRowBinding: AdapterContentsBinding) :
        RecyclerView.ViewHolder(itemRowBinding.root) {
        private var itemRowBindings: AdapterContentsBinding = itemRowBinding
        fun bind(obj: Content?) {
            if (obj != null) {
                if (obj.images != null) {
                    val imagesAdapter = ImagesAdapter(obj.images)
                    itemRowBindings.adapter = imagesAdapter
                }
            }
            itemRowBindings.executePendingBindings()
        }
    }
}