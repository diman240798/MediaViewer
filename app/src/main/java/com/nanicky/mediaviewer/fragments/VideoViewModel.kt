package com.nanicky.mediaviewer.fragments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nanicky.mediaviewer.repo.VideoRepository
import kotlinx.coroutines.launch

class VideoViewModel : ViewModel() {
    fun getVideos() {
        viewModelScope.launch {
            VideoRepository().getAllVideos()
        }
    }
}
