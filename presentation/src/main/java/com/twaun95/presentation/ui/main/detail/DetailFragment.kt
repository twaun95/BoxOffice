package com.twaun95.presentation.ui.main.detail

import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.twaun95.domain.model.entity.movie.BoxOfficeEntity
import com.twaun95.presentation.R
import com.twaun95.presentation.base.BaseFragment
import com.twaun95.presentation.databinding.FragmentDetailBinding
import com.twaun95.presentation.ui.main.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment(private val movie: BoxOfficeEntity) : BaseFragment<FragmentDetailBinding, DetailFragmentViewModel>(R.layout.fragment_detail){

    override val fragmentVM by viewModels<DetailFragmentViewModel>()
    private val activityVM by activityViewModels<MainActivityViewModel>()

    override fun initView() {
        super.initView()

        binding.activityVM = activityVM
        binding.fragmentVM = fragmentVM

        fragmentVM.initData(movie)
        fragmentVM.getMovieInfo(movie.code)
    }
    companion object {
        fun getInstance(movie: BoxOfficeEntity) : DetailFragment = DetailFragment(movie)
    }
}