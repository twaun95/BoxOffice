package com.twaun95.presentation.ui.main

import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.twaun95.presentation.R
import com.twaun95.presentation.adapter.dailyBoxOffice.DailyBoxOfficeAdapter
import com.twaun95.presentation.adapter.dailyBoxOffice.DailyBoxOfficeDecoration
import com.twaun95.presentation.adapter.dailyBoxOffice.DailyBoxOfficeLayoutManager
import com.twaun95.presentation.base.BaseActivity
import com.twaun95.presentation.databinding.ActivityMainBinding
import com.twaun95.presentation.util.StringFormat
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    private val viewModel by viewModels<MainActivityViewModel>()
    private val dailyBoxOfficeAdapter by lazy { DailyBoxOfficeAdapter() }

    override fun initView() {
        super.initView()
        binding.viewModel = viewModel
        binding.recyclerDailyBoxOffice.apply {
            layoutManager = DailyBoxOfficeLayoutManager(this@MainActivity)
            addItemDecoration(DailyBoxOfficeDecoration())
            adapter = dailyBoxOfficeAdapter.apply {
                onItemClickListener = {
                    Timber.d("onItemClickListener")
                }
            }
        }
    }

    override fun setEvent() {
        super.setEvent()
    }

    override fun setObserver() {
        super.setObserver()
//        viewModel.dailyBoxOffice.observe(this) {
//            Timber.d("livedata ${it}")
//        }
        viewModel.dailyBoxOfficeFlow
            .onEach {
                dailyBoxOfficeAdapter.submitList(it)
                Timber.d("flow: ${it}")
            }
            .launchIn(this.lifecycleScope)
    }
}