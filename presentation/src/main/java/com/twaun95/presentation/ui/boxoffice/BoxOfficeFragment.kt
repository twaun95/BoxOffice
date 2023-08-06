package com.twaun95.presentation.ui.boxoffice

import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.twaun95.presentation.R
import com.twaun95.presentation.base.BaseFragment
import com.twaun95.presentation.databinding.FragmentBoxofficeBinding
import com.twaun95.presentation.ui.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BoxOfficeFragment :
    BaseFragment<FragmentBoxofficeBinding, BoxOfficeFragmentViewModel>(R.layout.fragment_boxoffice){

    override val fragmentVM: BoxOfficeFragmentViewModel by viewModels()
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
        fun getInstance(): BoxOfficeFragment = BoxOfficeFragment()
    }
}