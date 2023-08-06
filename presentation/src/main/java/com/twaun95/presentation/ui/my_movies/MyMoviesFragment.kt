package com.twaun95.presentation.ui.my_movies

import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.twaun95.presentation.R
import com.twaun95.presentation.base.BaseFragment
import com.twaun95.presentation.databinding.FragmentMyMoviesBinding
import com.twaun95.presentation.ui.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyMoviesFragment :
    BaseFragment<FragmentMyMoviesBinding, MyMoviesFragmentViewModel>(R.layout.fragment_my_movies) {

    override val fragmentVM: MyMoviesFragmentViewModel by viewModels()
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
        fun getInstance(): MyMoviesFragment = MyMoviesFragment()
    }
}