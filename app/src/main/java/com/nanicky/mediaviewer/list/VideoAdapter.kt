package com.nanicky.mediaviewer.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.nanicky.mediaviewer.R
import com.nanicky.mediaviewer.databinding.VideoItemBinding
import com.nanicky.mediaviewer.db.VideoDetails

class VideoAdapter(var data: MutableList<VideoDetails>) : RecyclerView.Adapter<VideoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val binding: VideoItemBinding = DataBindingUtil.inflate<VideoItemBinding>(
                LayoutInflater.from(parent.context), R.layout.video_item, parent, false);
        return VideoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) = holder.bind(data[position])

    override fun getItemCount(): Int = data.size

}
