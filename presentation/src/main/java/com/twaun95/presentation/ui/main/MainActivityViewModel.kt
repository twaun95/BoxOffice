package com.twaun95.presentation.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.twaun95.domain.model.MovieEntity
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

    private val _dailyBoxOffice = MutableLiveData(listOf<MovieEntity>())
    val dailyBoxOffice: LiveData<List<MovieEntity>>
        get() = _dailyBoxOffice

    fun getBoxOfficeList() {
        viewModelScope.launch {
            startLoading()
            val result = getBoxOfficeUseCase("20210102")
            when(result) {
                is Result.Success ->{
                    _dailyBoxOffice.value = result.data
                    Timber.d("${_dailyBoxOffice.value}")
                }
                is Result.Fail -> {
                    Timber.d("${result.exception}")
                }
            }
            stopLoading()
        }
    }
}