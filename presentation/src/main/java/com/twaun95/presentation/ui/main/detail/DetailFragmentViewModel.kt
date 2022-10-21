package com.twaun95.presentation.ui.main.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.twaun95.domain.model.Result
import com.twaun95.domain.model.entity.BoxOfficeEntity
import com.twaun95.domain.model.entity.MovieEntity
import com.twaun95.domain.usecase.GetMovieInfoUseCase
import com.twaun95.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class DetailFragmentViewModel @Inject constructor(
    private val getMovieInfoUseCase: GetMovieInfoUseCase
) : BaseViewModel() {

    private val _boxOfficeInfo = MutableLiveData<BoxOfficeEntity>()
    val boxOfficeInfo: LiveData<BoxOfficeEntity>
        get() = _boxOfficeInfo

    private val _movieInfo = MutableStateFlow(MovieEntity.empty())
    val movieInfo: StateFlow<MovieEntity>
        get() = _movieInfo

    fun initData(boxOfficeInfo: BoxOfficeEntity) {
        _boxOfficeInfo.value = boxOfficeInfo
    }

    fun getMovieInfo(movieCode: String) {
        viewModelScope.launch {
            startLoading()
            val result = getMovieInfoUseCase(movieCode)
            when(result) {
                is Result.Success ->{
                    _movieInfo.value = result.data
                    Timber.d("${_movieInfo.value}")
                }
                is Result.Fail -> { Timber.d("${result.exception}") }
            }
            stopLoading()
        }
    }
}