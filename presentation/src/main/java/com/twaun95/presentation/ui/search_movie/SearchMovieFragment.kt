package com.twaun95.presentation.ui.search_movie

import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.twaun95.presentation.R
import com.twaun95.presentation.adapter.searchMovie.SearchMovieAdapter
import com.twaun95.presentation.adapter.searchMovie.SearchMovieDecoration
import com.twaun95.presentation.adapter.searchMovie.SearchMovieLayoutManager
import com.twaun95.presentation.base.BaseFragment
import com.twaun95.presentation.databinding.FragmentSearchMovieBinding
import com.twaun95.presentation.ui.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import timber.log.Timber

@AndroidEntryPoint
class SearchMovieFragment :
    BaseFragment<FragmentSearchMovieBinding, SearchMovieFragmentViewModel>(R.layout.fragment_search_movie) {

    override val fragmentVM: SearchMovieFragmentViewModel by viewModels()
    private val activityVM by activityViewModels<MainActivityViewModel>()

    private val searchMovieAdapter by lazy {
        SearchMovieAdapter(
            onItemClickListener = { item ->
                // 이동
            }
        )
    }

    override fun initView() {
        super.initView()
        binding.activity = activity
        binding.fragmentVM = fragmentVM

        binding.rvSearch.apply {
            layoutManager = SearchMovieLayoutManager(requireContext())
            addItemDecoration(SearchMovieDecoration())
            adapter = searchMovieAdapter
        }
    }

    override fun setObserver() {
        super.setObserver()

        fragmentVM.error
            .onEach { message ->
                Timber.d(message)
            }
            .launchIn(viewLifecycleOwner.lifecycleScope)

        fragmentVM.searchMovieResult
            .onEach {
                searchMovieAdapter.submitList(it)
            }
            .launchIn(viewLifecycleOwner.lifecycleScope)
    }

    override fun setEvent() {
        super.setEvent()
    }

    override fun onStart() {
        super.onStart()
        fragmentVM.searchMovie()
    }

    companion object {
        fun getInstance(): SearchMovieFragment = SearchMovieFragment()
    }
}