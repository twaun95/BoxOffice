package com.twaun95.presentation.ui.main

import androidx.lifecycle.viewModelScope
import com.twaun95.domain.model.MovieEntity
import com.twaun95.domain.model.Result
import com.twaun95.domain.usecase.GetBoxOfficeUseCase
import com.twaun95.presentation.base.BaseViewModel
import com.twaun95.presentation.util.StringFormat
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val getBoxOfficeUseCase: GetBoxOfficeUseCase
) : BaseViewModel() {

    private val _dailyBoxOffices = MutableStateFlow(emptyList<MovieEntity>())
    val dailyBoxOffices: StateFlow<List<MovieEntity>>
        get() = _dailyBoxOffices

    init {
        getBoxOfficeList()
    }

    fun getBoxOfficeList() {
        viewModelScope.launch {
            startLoading()
            val result = getBoxOfficeUseCase(StringFormat.yesterdayDate())
            when(result) {
                is Result.Success ->{
                    _dailyBoxOffices.value = result.data
                    Timber.d("${_dailyBoxOffices.value}")

                }
                is Result.Fail -> { Timber.d("${result.exception}") }
            }
            stopLoading()
        }
    }
}