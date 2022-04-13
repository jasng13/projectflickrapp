package com.del.flickrapp.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.del.flickrapp.R
import com.del.flickrapp.databinding.PhotoItemBinding
import com.del.flickrapp.model.Photo

class PhotoListAdapter(private val list: List<Photo>) :
    RecyclerView.Adapter<PhotoListAdapter.PhotoViewHolder>() {
    /**
     * @PhotoViewHolder is custom viewholder class
     */
    class PhotoViewHolder(private val binding: PhotoItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(searchItem: Photo) {
            binding.items = searchItem
            binding.executePendingBindings()
        }
    }

    /**
     * inflate photo item layout to recycler view
     * @param parent
     * @param viewType
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val binding: PhotoItemBinding =
            DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.photo_item, parent,false)
        return PhotoViewHolder(binding)
    }

    /**
     * onBindViewHolder
     * @param holder
     * @param position
     */
    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bind(list[position])
    }

    /**
     * @return size of list
     */
    override fun getItemCount(): Int {
        return list.size
    }
}