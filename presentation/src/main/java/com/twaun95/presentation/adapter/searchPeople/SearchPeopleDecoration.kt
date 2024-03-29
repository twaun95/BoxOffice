package com.twaun95.presentation.adapter.searchPeople

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class SearchPeopleDecoration : RecyclerView.ItemDecoration() {
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