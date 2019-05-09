package com.nanicky.mediaviewer.list

import androidx.recyclerview.widget.DiffUtil
import java.util.*

class CommonDiffUti(val oldData: List<Any>, val newData: List<Any>) : DiffUtil.Callback() {


    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean = Objects.equals(
            oldData[oldItemPosition],
            newData[newItemPosition])


    override fun getOldListSize(): Int = oldData.size

    override fun getNewListSize(): Int = newData.size

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean = Objects.equals(
            oldData[oldItemPosition],
            newData[newItemPosition])

}