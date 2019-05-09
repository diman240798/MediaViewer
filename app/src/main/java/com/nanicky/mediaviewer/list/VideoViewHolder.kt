package com.nanicky.mediaviewer.list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.nanicky.mediaviewer.databinding.VideoItemBinding;
import com.nanicky.mediaviewer.db.VideoDetails

class VideoViewHolder(val binding: VideoItemBinding) : RecyclerView.ViewHolder(binding.root) {
    init {

    }

    fun bind(video:VideoDetails) {
        binding.video = video;
    }
}
