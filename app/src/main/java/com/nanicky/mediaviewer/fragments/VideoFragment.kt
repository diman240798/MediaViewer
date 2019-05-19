package com.nanicky.mediaviewer.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.MediaController
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.nanicky.mediaviewer.R
import com.nanicky.mediaviewer.db.DataBase
import com.nanicky.mediaviewer.db.dao.VideoDao
import com.nanicky.mediaviewer.db.model.VideoDetails
import com.nanicky.mediaviewer.repo.VideoRepository
import kotlinx.android.synthetic.main.fragment_video.*
import kotlinx.android.synthetic.main.bottom_sheet.*
import com.nanicky.mediaviewer.util.onBottomSheetSlide;
import com.nanicky.mediaviewer.util.onBottomSheetStateChanged;
import java.lang.RuntimeException

class VideoFragment : Fragment() {
    // fields
    private lateinit var videoRepository: VideoRepository
    // viewa
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<LinearLayout>
    private lateinit var videoController: MediaController


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_video, container, false)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        var list: RecyclerView = RecyclerView(this.context!!)
//
//        list.stopNestedScroll(View.OVER_SCROLL_ALWAYS)


//        update.setOnClickListener { getNewVideos(Collections.emptyList(), Collections.emptyList()) }

        videoController = MediaController(context)
        videoController.visibility = View.GONE

        video_view.setMediaController(videoController)

        val context = context ?: throw RuntimeException("NoContext")
        val appDataBase = DataBase.getAppDataBase(context)

        val videoDao = appDataBase!!.videoDao()

        videoRepository = VideoRepository(videoDao)

        val videos : List<VideoDetails> = videoRepository.getAllVideos(context)

        setUpFab()
        setUpBottomSheetView()
        setUpBottomSheetBottomView()
        setUpBottomSheetBehavior()
    }

    private fun setUpBottomSheetBottomView() {

    }

    private fun setUpBottomSheetBehavior() {
        bottomSheetBehavior = BottomSheetBehavior.from(bottom_sheet)
        bottomSheetBehavior.isHideable = true
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN

        bottomSheetBehavior.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                onBottomSheetStateChanged(newState, listView, videoController)
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                onBottomSheetSlide(slideOffset, video_outer, fab, video_surrounder)
            }
        })
    }

    private fun setUpBottomSheetView() {
        stop_button.setOnClickListener {
            if (video_view.isPlaying) {
                video_view.pause()
                stop_button.setImageResource(android.R.drawable.ic_media_play)
            } else {
                video_view.start()
                stop_button.setImageResource(android.R.drawable.ic_media_pause)
            }
        }
    }

    @SuppressLint("RestrictedApi")
    private fun setUpFab() {
        fab.visibility = View.GONE
        fab.setOnClickListener {
            startVideo()
        }
    }

    private fun setVideos() {

//        getNewVideos(allMedia, allMediaThumbs)
    }


    private fun startVideo() {
        stop_button.setImageResource(android.R.drawable.ic_media_pause)
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
        video_view.start()
    }

    override fun onResume() {
        super.onResume()
        if (video_view.isPlaying) {
            stop_button.setImageResource(android.R.drawable.ic_media_pause)
        } else {
            stop_button.setImageResource(android.R.drawable.ic_media_play)
        }
    }
}


















/*private fun getNewVideos(allMedia: MutableList<VideoDetails>, allMediaThumbs: MutableList<Bitmap>) {
       progressBar.visibility = View.VISIBLE

       var allMedia1 = ArrayList<VideoDetails>(allMedia)
       val allMediaThumbs1 = ArrayList<Bitmap>(allMediaThumbs)

       Thread {
           val listVideos = ArrayList<VideoDetails>()

           if (allMedia1.isEmpty()) allMedia1 = getVideoFromDevice(context)

           if (allMediaThumbs1.isEmpty()) {
               for (vid in allMedia1) {
                   Log.d("video", vid.path)
                   val thumb: Bitmap =
                           ThumbnailUtils.createVideoThumbnail(vid.path, MediaStore.Images.Thumbnails.MINI_KIND)
                   allMediaThumbs1.add(thumb)
               }
               SharedPreferenceUtil.setVideosThumbs(context, allMediaThumbs1)
               SharedPreferenceUtil.setVideos(context, allMedia1)
               SharedPreferenceUtil.setVideosSize(context, allMedia1.size)
           }

           for (i in 0..(allMedia1.size - 1)) {
               val thumb: Bitmap = allMediaThumbs1[i]
               val vid = allMedia1[i]
               Log.d("video SETTING", vid)
               listVideos.add(VideoDetails(thumb, vid))
           }

           val frontListBaseAdapter = VideoListBaseAdapter(context, listVideos)


           activity?.runOnUiThread {
               setVideos(frontListBaseAdapter, listVideos)
               progressBar.visibility = View.GONE
           }

       }.start()
   }*/

/*@SuppressLint("RestrictedApi")
private fun setVideos(frontListBaseAdapter: VideoListBaseAdapter, listVideos: ArrayList<VideoDetails>) {
    listView.adapter = frontListBaseAdapter
    // on Item Click
    listView.setOnItemClickListener { parent, view, position, id ->
        val allowed = (bottomSheetBehavior.state == BottomSheetBehavior.STATE_COLLAPSED
                || (bottomSheetBehavior.state == BottomSheetBehavior.STATE_HIDDEN && bottomSheetBehavior.isHideable))
        if (!allowed) return@setOnItemClickListener

        if (bottomSheetBehavior.isHideable) {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
            bottomSheetBehavior.isHideable = false
        }


        video_view.setVideoPath(listVideos[position].path)
        startVideo()
    }
    // on Item Click
}*/