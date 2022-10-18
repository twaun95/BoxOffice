package com.twaun95.presentation.adapter.dailyBoxOffice

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class DailyBoxOfficeDecoration : RecyclerView.ItemDecoration() {
    companion object {
        private const val VERTICAL_GAP_HALF = (20f / 780f) / 2f;
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.bottom = 20f.toInt()

        val itemCount = parent.adapter?.itemCount ?: 0
        val position: Int = parent.getChildAdapterPosition(view)

//        if (itemCount==1) {
//            outRect.bottom = (parent.height * VERTICAL_GAP_HALF).toInt()
//            outRect.top = (parent.height * VERTICAL_GAP_HALF).toInt()
//            return
//        }
//
//        when (position) {
//            0 -> {
//                outRect.bottom = (parent.height * VERTICAL_GAP_HALF).toInt()
//            }
//            itemCount-1 -> {
//                outRect.top = (parent.height * VERTICAL_GAP_HALF).toInt()
//            }
//            else -> {
//                outRect.bottom = (parent.height * VERTICAL_GAP_HALF).toInt()
//                outRect.top = (parent.height * VERTICAL_GAP_HALF).toInt()
//            }
//        }
    }
}