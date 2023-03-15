package com.example.core.utils

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

object Utils {

    const val RECYCLER_ITEM_SPACE = 50

    fun RecyclerView.addHorizontalSpaceDecoration(space: Int) {
        addItemDecoration(
            object : RecyclerView.ItemDecoration() {
                override fun getItemOffsets(
                    outRect: Rect,
                    view: View,
                    parent: RecyclerView,
                    state: RecyclerView.State
                ) {
                    val position = parent.getChildAdapterPosition(view)
                    if (position != 0 && position != parent.adapter?.itemCount) {
                        outRect.top = space
                    }
                }
            }
        )
    }
}