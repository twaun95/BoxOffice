package com.twaun95.presentation.adapter.binding

import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.fragment.app.FragmentActivity
import com.twaun95.presentation.ui.search_movie.SearchMovieFragmentViewModel

@BindingAdapter("android:visibility")
fun setVisibility(view: View, visible: Boolean) {
    view.visibility = if (visible) View.VISIBLE else View.GONE
}

@BindingAdapter("android:activity", "android:onKeyBoardSearch")
fun setOnKeyBoardSearch(view: EditText, activity: FragmentActivity, fragmentVM: SearchMovieFragmentViewModel) {

    view.setOnEditorActionListener { v, actionId, event ->
        when (actionId) {
            EditorInfo.IME_ACTION_SEARCH -> {
                fragmentVM.searchMovie()
                view.clearFocus()
                val imm: InputMethodManager =
                    activity.getSystemService(AppCompatActivity.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(v.windowToken, 0)
            }
            else -> {}
        }
        true
    }
}