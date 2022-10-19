package com.twaun95.presentation.adapter.dailyBoxOffice

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class DailyBoxOfficeDecoration : RecyclerView.ItemDecoration() {
    companion object {
        private const val VERTICAL_GAP = 10
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.bottom = VERTICAL_GAP
    }
}