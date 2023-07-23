package com.twaun95.presentation.ui.main.detail

import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.twaun95.domain.model.entity.movie.BoxOfficeEntity
import com.twaun95.presentation.R
import com.twaun95.presentation.base.BaseFragment
import com.twaun95.presentation.databinding.FragmentDetailBinding
import com.twaun95.presentation.ui.main.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import timber.log.Timber

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

    override fun setObserver() {
        super.setObserver()
        fragmentVM.error
            .onEach { message ->
                Timber.d(message)
            }
            .launchIn(viewLifecycleOwner.lifecycleScope)

        fragmentVM.action
            .onEach { action ->
                when(action) {
                    DetailFragmentViewModel.Action.Back -> {
                        // 뒤로
                    }
                    DetailFragmentViewModel.Action.Save -> {
                        // 저장
                    }
                }
            }
            .launchIn(viewLifecycleOwner.lifecycleScope)
    }

    companion object {
        fun getInstance(movie: BoxOfficeEntity) : DetailFragment = DetailFragment(movie)
    }
}