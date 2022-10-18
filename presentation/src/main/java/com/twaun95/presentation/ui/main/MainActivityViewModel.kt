package com.twaun95.presentation.ui.main

import androidx.lifecycle.viewModelScope
import com.twaun95.domain.model.Result
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

    // boxofficelist

    fun getBoxOfficeList() {
        viewModelScope.launch {
            startLoading()
            val result = getBoxOfficeUseCase("20210102")
            when(result) {
                is Result.Success ->{
                    Timber.d(result.data.toString())
                }
                is Result.Fail -> {
                    Timber.d("${result.exception}")
                }
            }
            stopLoading()
        }
    }
}