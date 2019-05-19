package com.nanicky.mediaviewer.list

import androidx.recyclerview.widget.RecyclerView
import com.nanicky.mediaviewer.databinding.VideoItemBinding
import com.nanicky.mediaviewer.db.model.VideoDetails

class VideoViewHolder(val binding: VideoItemBinding) : RecyclerView.ViewHolder(binding.root) {
    init {

    }

    fun bind(video: VideoDetails) {
        binding.video = video;
    }
}
