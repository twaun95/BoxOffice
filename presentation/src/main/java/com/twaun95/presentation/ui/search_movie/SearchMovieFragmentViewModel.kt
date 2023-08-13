package com.twaun95.presentation.ui.search_movie

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.twaun95.domain.model.Result
import com.twaun95.domain.model.entity.movie.MovieEntity
import com.twaun95.domain.usecase.movie.SearchMoviesUseCase
import com.twaun95.presentation.base.BaseViewModel
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

    private val _searchMovieResult = MutableStateFlow(emptyList<MovieEntity>())
    val searchMovieResult: StateFlow<List<MovieEntity>> get() = _searchMovieResult

    val inputSearch by lazy { MutableLiveData<String>("") }

    fun searchMovie() {
        viewModelScope.launch {
            startLoading()
            val result = searchMoviesUseCase(inputSearch.value?:"")
            when(result) {
                is Result.Success ->{
                    _searchMovieResult.value = result.data
                }
                is Result.Fail -> {
                    _searchMovieResult.value = emptyList()
                    onError(result.exception.message)
                }
            }
            stopLoading()
        }
    }

    fun deleteInput() {
        inputSearch.value = ""
    }
}