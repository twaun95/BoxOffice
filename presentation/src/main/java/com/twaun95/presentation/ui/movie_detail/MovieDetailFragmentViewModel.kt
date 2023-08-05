package com.twaun95.presentation.ui.movie_detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.twaun95.domain.model.Result
import com.twaun95.domain.model.entity.movie.BoxOfficeEntity
import com.twaun95.domain.model.entity.movie.MovieEntity
import com.twaun95.domain.usecase.GetMovieInfoUseCase
import com.twaun95.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MovieDetailFragmentViewModel @Inject constructor(
    private val getMovieInfoUseCase: GetMovieInfoUseCase
) : BaseViewModel() {

    private val _action = MutableSharedFlow<Action>()
    val action: SharedFlow<Action> get() = _action

    private val _boxOfficeInfo = MutableLiveData<BoxOfficeEntity>()
    private val _movieInfo = MutableStateFlow(MovieEntity.empty())
    val movieInfo: StateFlow<MovieEntity> get() = _movieInfo

    fun initData(boxOfficeInfo: BoxOfficeEntity) {
        _boxOfficeInfo.value = boxOfficeInfo
    }

    fun getMovieItem() {
        viewModelScope.launch {
            startLoading()
            val result = getMovieInfoUseCase(_boxOfficeInfo.value?.code ?: "")
            when(result) {
                is Result.Success ->{
                    _movieInfo.emit(result.data)
                    Timber.d("${_movieInfo.value}")
                }
                is Result.Fail -> {
                    onError(result.exception.message)
                }
            }
            stopLoading()
        }
    }


    sealed class Action {
        object Back: Action()
        object Save: Action()
    }
}