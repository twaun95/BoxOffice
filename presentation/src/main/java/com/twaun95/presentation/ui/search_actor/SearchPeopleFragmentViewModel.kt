package com.twaun95.presentation.ui.search_actor

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.twaun95.domain.model.Result
import com.twaun95.domain.model.entity.movie.PeopleEntity
import com.twaun95.domain.usecase.people.SearchPeopleUseCase
import com.twaun95.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchPeopleFragmentViewModel @Inject constructor(
    private val searchPeopleUseCase: SearchPeopleUseCase
) : BaseViewModel() {

    private val _searchPeopleResult = MutableStateFlow(emptyList<PeopleEntity>())
    val searchPeopleResult: StateFlow<List<PeopleEntity>> get() = _searchPeopleResult

    val inputSearch by lazy { MutableLiveData<String>("") }

    init {
        searchPeople()
    }

    fun searchPeople() {
        viewModelScope.launch {
            startLoading()
            val result = searchPeopleUseCase(inputSearch.value?:"")
            when(result) {
                is Result.Success ->{
                    _searchPeopleResult.value = result.data
                }
                is Result.Fail -> {
                    _searchPeopleResult.value = emptyList()
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