package com.twaun95.presentation.ui.search_movie

import androidx.lifecycle.viewModelScope
import com.twaun95.domain.model.Result
import com.twaun95.domain.model.entity.movie.BoxOfficeEntity
import com.twaun95.domain.model.entity.movie.MovieEntity
import com.twaun95.domain.usecase.movie.SearchMoviesUseCase
import com.twaun95.presentation.base.BaseViewModel
import com.twaun95.presentation.util.StringFormat
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class SearchMovieFragmentViewModel @Inject constructor(
    private val searchMoviesUseCase: SearchMoviesUseCase
) : BaseViewModel() {

    private val _movies = MutableStateFlow(emptyList<MovieEntity>())
    val movies: StateFlow<List<MovieEntity>> get() = _movies


    fun searchMovie() {
        viewModelScope.launch {
            startLoading()
            val result = searchMoviesUseCase("밀수").also {
                Timber.d("TWAUN 검색결과: $it")
            }
            when(result) {
                is Result.Success ->{
                    _movies.value = result.data
                }
                is Result.Fail -> {
                    onError(result.exception.message)
                }
            }
            stopLoading()
        }
    }
}