package com.twaun95.presentation.ui.search_movie

import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.twaun95.presentation.R
import com.twaun95.presentation.base.BaseFragment
import com.twaun95.presentation.databinding.FragmentSearchMovieBinding
import com.twaun95.presentation.ui.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchMovieFragment :
    BaseFragment<FragmentSearchMovieBinding, SearchMovieFragmentViewModel>(R.layout.fragment_search_movie) {

    override val fragmentVM: SearchMovieFragmentViewModel by viewModels()
    private val activityVM by activityViewModels<MainActivityViewModel>()

    override fun initView() {
        super.initView()
    }

    override fun setObserver() {
        super.setObserver()
    }

    override fun setEvent() {
        super.setEvent()
    }

    companion object {
        fun getInstance(): SearchMovieFragment = SearchMovieFragment()
    }
}