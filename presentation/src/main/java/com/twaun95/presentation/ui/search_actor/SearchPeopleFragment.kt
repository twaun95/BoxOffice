package com.twaun95.presentation.ui.search_actor

import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.twaun95.presentation.R
import com.twaun95.presentation.adapter.searchPeople.SearchPeopleAdapter
import com.twaun95.presentation.adapter.searchPeople.SearchPeopleDecoration
import com.twaun95.presentation.adapter.searchPeople.SearchPeopleLayoutManager
import com.twaun95.presentation.base.BaseFragment
import com.twaun95.presentation.databinding.FragmentSearchPeopleBinding
import com.twaun95.presentation.ui.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import timber.log.Timber

@AndroidEntryPoint
class SearchPeopleFragment :
    BaseFragment<FragmentSearchPeopleBinding, SearchPeopleFragmentViewModel>(R.layout.fragment_search_people) {

    override val fragmentVM: SearchPeopleFragmentViewModel by viewModels()
    private val activityVM by activityViewModels<MainActivityViewModel>()

    private val searchPeopleAdapter by lazy {
        SearchPeopleAdapter(
            onItemClickListener = { item ->

            }
        )
    }

    override fun initView() {
        super.initView()

        binding.activity = activity
        binding.fragmentVM = this.fragmentVM

        binding.rvSearch.apply {
            layoutManager = SearchPeopleLayoutManager(requireContext())
            addItemDecoration(SearchPeopleDecoration())
            adapter = searchPeopleAdapter
        }
    }

    override fun setObserver() {
        super.setObserver()

        fragmentVM.error
            .onEach { message ->
                Timber.d(message)
            }
            .launchIn(viewLifecycleOwner.lifecycleScope)

        fragmentVM.searchPeopleResult
            .onEach {
                searchPeopleAdapter.submitList(it)
            }
            .launchIn(viewLifecycleOwner.lifecycleScope)
    }

    override fun setEvent() {
        super.setEvent()
    }

}