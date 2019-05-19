package com.nanicky.mediaviewer.util

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.Resources
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.MediaController
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.nanicky.mediaviewer.R
import kotlinx.android.synthetic.main.fragment_video.*

@SuppressLint("RestrictedApi")
fun onBottomSheetSlide(slideOffset: Float, video_outer: ViewGroup, fab: ExtendedFloatingActionButton, video_surrounder: ViewGroup) {
    Log.d("SlideOffset", slideOffset.toString())

    var context = video_outer.context;

    val initialWidth = context.resources.getDimension(R.dimen.video_menu_height).toInt()
    val widthDifMax = Resources.getSystem().displayMetrics.widthPixels - initialWidth
    var heightDifMax = Resources.getSystem().displayMetrics.widthPixels - initialWidth


    val btwAnim = 0.2F
    if (slideOffset <= btwAnim) {
        val percent: Float = slideOffset / btwAnim

        // animate fab
        fab.animate().scaleX(1 - percent).scaleY(1 - percent).setDuration(0).start()


        val animWidth = (initialWidth + widthDifMax * percent).toDouble()

        val layoutParams = video_outer.layoutParams
        layoutParams.width = Math.ceil(animWidth).toInt()
        video_outer.layoutParams = layoutParams

    } else {
        // ensure fab is fully hidden
        fab.animate().scaleX(0F).scaleY(0F).setDuration(0).start()

        if (fab.visibility == View.GONE) {
            fab.visibility = View.VISIBLE
        }

        // ensure width set to max
        val layoutParamsWidth = video_outer.layoutParams
        layoutParamsWidth.width = widthDifMax + initialWidth
        video_outer.layoutParams = layoutParamsWidth
    }

    //val percent: Float = (slideOffset - btwAnim) / (1 - btwAnim);
    //var animWidth = (initialWidth + heightDifMax * percent).toDouble() // after

    val animWidth =
            (initialWidth + (Resources.getSystem().displayMetrics.heightPixels.toDouble() / 2 - 160) * slideOffset)

    // animate View
    val layoutParamsView = video_outer.layoutParams
    layoutParamsView.height = Math.ceil(animWidth).toInt()
    video_outer.layoutParams = layoutParamsView

    // animate Parent
    val layoutParamsSurrender = video_surrounder.layoutParams
    layoutParamsSurrender.height = Math.ceil(animWidth).toInt()
    video_surrounder.layoutParams = layoutParamsSurrender
}

fun onBottomSheetStateChanged(newState: Int, listView: ListView, videoController: MediaController) {
    when (newState) {
        BottomSheetBehavior.STATE_COLLAPSED -> listView.isNestedScrollingEnabled = true

        BottomSheetBehavior.STATE_EXPANDED -> {
            videoController.visibility = View.VISIBLE
            videoController.hide()
            listView.isNestedScrollingEnabled = false
        }

        else -> videoController.visibility = View.GONE
    }
}