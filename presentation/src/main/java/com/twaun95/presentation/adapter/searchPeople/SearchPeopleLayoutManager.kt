package com.twaun95.presentation.adapter.searchPeople

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SearchPeopleLayoutManager(
    context: Context
) : LinearLayoutManager(context, VERTICAL, false) {

    override fun checkLayoutParams(lp: RecyclerView.LayoutParams): Boolean {
        lp.height = (height/7).toInt()
        return super.checkLayoutParams(lp)
    }
}
