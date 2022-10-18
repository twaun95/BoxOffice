package com.twaun95.presentation.ui.main

import androidx.activity.viewModels
import com.twaun95.presentation.R
import com.twaun95.presentation.base.BaseActivity
import com.twaun95.presentation.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    private val viewModel by viewModels<MainActivityViewModel>()

    override fun initView() {
        super.initView()
        binding.viewModel = viewModel
    }

    override fun setEvent() {
        super.setEvent()
    }

    override fun setObserver() {
        super.setObserver()
    }
}