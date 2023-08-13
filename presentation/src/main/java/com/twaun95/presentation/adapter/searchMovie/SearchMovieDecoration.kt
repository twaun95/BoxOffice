package com.twaun95.presentation.adapter.searchMovie

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class SearchMovieDecoration : RecyclerView.ItemDecoration() {
    companion object {
        private const val VERTICAL_GAP = 2
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