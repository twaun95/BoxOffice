package com.twaun95.presentation.ui.movie_detail

import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.twaun95.presentation.R
import com.twaun95.presentation.base.BaseFragment
import com.twaun95.presentation.databinding.FragmentMovieDetailBinding
import com.twaun95.presentation.ui.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import timber.log.Timber

@AndroidEntryPoint
class MovieDetailFragment :
    BaseFragment<FragmentMovieDetailBinding, MovieDetailFragmentViewModel>(R.layout.fragment_movie_detail) {

    override val fragmentVM by viewModels<MovieDetailFragmentViewModel>()
    private val activityVM by activityViewModels<MainActivityViewModel>()

    override fun initView() {
        super.initView()

        binding.activityVM = activityVM
        binding.fragmentVM = fragmentVM

        activityVM.selectItem.value?.let { fragmentVM.initData(it) }
        fragmentVM.getMovieItem()
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
                when (action) {
                    MovieDetailFragmentViewModel.Action.Back -> {
                        // 뒤로
                    }

                    MovieDetailFragmentViewModel.Action.Save -> {
                        // 저장
                    }
                }
            }
            .launchIn(viewLifecycleOwner.lifecycleScope)
    }

    companion object {
        fun getInstance(): MovieDetailFragment = MovieDetailFragment()
    }
}