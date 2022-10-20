package com.twaun95.presentation.ui.main.detail

import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.twaun95.domain.model.MovieEntity
import com.twaun95.presentation.R
import com.twaun95.presentation.base.BaseFragment
import com.twaun95.presentation.databinding.FragmentDetailBinding
import com.twaun95.presentation.ui.main.MainActivityViewModel
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class DetailFragment(private val movie: MovieEntity) : BaseFragment<FragmentDetailBinding, DetailFragmentViewModel>(R.layout.fragment_detail){

    override val fragmentVM by viewModels<DetailFragmentViewModel>()
    private val activityVM by activityViewModels<MainActivityViewModel>()

    override fun initView() {
        super.initView()
        binding.fragmentVM = fragmentVM
        fragmentVM.initData(movie)
        Timber.d("${activityVM.dailyBoxOffices.value}")
    }
    companion object {
        fun getInstance(movie: MovieEntity) : DetailFragment = DetailFragment(movie)
    }
}