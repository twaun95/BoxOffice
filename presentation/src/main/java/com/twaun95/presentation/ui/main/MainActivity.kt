package com.twaun95.presentation.ui.main

import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.twaun95.presentation.R
import com.twaun95.presentation.adapter.dailyBoxOffice.DailyBoxOfficeAdapter
import com.twaun95.presentation.adapter.dailyBoxOffice.DailyBoxOfficeDecoration
import com.twaun95.presentation.adapter.dailyBoxOffice.DailyBoxOfficeLayoutManager
import com.twaun95.presentation.base.BaseActivity
import com.twaun95.presentation.databinding.ActivityMainBinding
import com.twaun95.presentation.ui.main.detail.DetailFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    private val viewModel by viewModels<MainActivityViewModel>()
    private val dailyBoxOfficeAdapter by lazy {
        DailyBoxOfficeAdapter(
            onItemClickListener = { item ->
                supportFragmentManager.beginTransaction().add(R.id.frameLayout_root, DetailFragment.getInstance(item)).addToBackStack(null).commit()
            }
        )
    }

    override fun initView() {
        super.initView()
        binding.viewModel = viewModel
        binding.recyclerDailyBoxOffice.apply {
            layoutManager = DailyBoxOfficeLayoutManager(this@MainActivity)
            addItemDecoration(DailyBoxOfficeDecoration())
            adapter = dailyBoxOfficeAdapter
        }
    }

    override fun setEvent() {
        super.setEvent()
        binding.layoutSwipe.setOnRefreshListener {
            viewModel.getBoxOfficeList()
            binding.layoutSwipe.isRefreshing = false
        }
    }

    override fun setObserver() {
        super.setObserver()
        viewModel.error
            .onEach { message ->
                Timber.d(message)
            }
            .launchIn(lifecycleScope)

        viewModel.action
            .onEach { action ->
                when(action) {
                    MainActivityViewModel.Action.Save -> {

                    }
                }
            }
            .launchIn(lifecycleScope)

        viewModel.dailyBoxOffices
            .onEach {
                dailyBoxOfficeAdapter.submitList(it)
            }
            .launchIn(this.lifecycleScope)
    }
}