package com.twaun95.presentation.ui.boxoffice

import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.twaun95.presentation.R
import com.twaun95.presentation.adapter.dailyBoxOffice.DailyBoxOfficeAdapter
import com.twaun95.presentation.adapter.dailyBoxOffice.DailyBoxOfficeDecoration
import com.twaun95.presentation.adapter.dailyBoxOffice.DailyBoxOfficeLayoutManager
import com.twaun95.presentation.base.BaseFragment
import com.twaun95.presentation.databinding.FragmentBoxofficeBinding
import com.twaun95.presentation.ui.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import timber.log.Timber

@AndroidEntryPoint
class BoxOfficeFragment :
    BaseFragment<FragmentBoxofficeBinding, BoxOfficeFragmentViewModel>(R.layout.fragment_boxoffice){

    override val fragmentVM: BoxOfficeFragmentViewModel by viewModels()
    private val activityVM by activityViewModels<MainActivityViewModel>()

    private val dailyBoxOfficeAdapter by lazy {
        DailyBoxOfficeAdapter(
            onItemClickListener = { item ->
                val bundle = bundleOf("movieCode" to item.code)
                findNavController().navigate(R.id.action_boxOfficeFragment_to_movieDetailFragment, bundle)
            }
        )
    }

    override fun initView() {
        super.initView()

        binding.viewModel = fragmentVM

        binding.recyclerDailyBoxOffice.apply {
            layoutManager = DailyBoxOfficeLayoutManager(requireContext())
            addItemDecoration(DailyBoxOfficeDecoration())
            adapter = dailyBoxOfficeAdapter
        }
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
                    BoxOfficeFragmentViewModel.Action.Save -> {

                    }
                }
            }
            .launchIn(viewLifecycleOwner.lifecycleScope)

        fragmentVM.dailyBoxOffices
            .onEach {
                dailyBoxOfficeAdapter.submitList(it)
            }
            .launchIn(viewLifecycleOwner.lifecycleScope)
    }

    override fun setEvent() {
        super.setEvent()

        binding.layoutSwipe.setOnRefreshListener {
            fragmentVM.getBoxOfficeList()
            binding.layoutSwipe.isRefreshing = false
        }
    }

    override fun onStart() {
        super.onStart()
    }
}