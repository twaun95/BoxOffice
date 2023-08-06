package com.twaun95.presentation.ui.search_actor

import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.twaun95.presentation.R
import com.twaun95.presentation.base.BaseFragment
import com.twaun95.presentation.databinding.FragmentSearchActorBinding
import com.twaun95.presentation.ui.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchActorFragment :
    BaseFragment<FragmentSearchActorBinding, SearchActorFragmentViewModel>(R.layout.fragment_search_actor) {

    override val fragmentVM: SearchActorFragmentViewModel by viewModels()
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
        fun getInstance(): SearchActorFragment = SearchActorFragment()
    }
}