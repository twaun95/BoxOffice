package com.twaun95.presentation.ui.main

import androidx.lifecycle.viewModelScope
import com.twaun95.domain.usecase.GetBoxOfficeUseCase
import com.twaun95.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val getBoxOfficeUseCase: GetBoxOfficeUseCase
) : BaseViewModel() {

    fun getBoxOfficeList() {
//        viewModelScope.launch {
//            val result = getBoxOfficeUseCase()
            Timber.d("getBoxOfficeList")
//        }
    }
}