package com.twaun95.presentation.ui.boxoffice

import androidx.lifecycle.viewModelScope
import com.twaun95.domain.model.Result
import com.twaun95.domain.model.entity.movie.BoxOfficeEntity
import com.twaun95.domain.usecase.movie.GetBoxOfficeUseCase
import com.twaun95.presentation.base.BaseViewModel
import com.twaun95.presentation.util.StringFormat
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BoxOfficeFragmentViewModel @Inject constructor(
    private val getBoxOfficeUseCase: GetBoxOfficeUseCase
) : BaseViewModel() {

    private val _action = MutableSharedFlow<Action>()
    val action: SharedFlow<Action> get() = _action

    private val _dailyBoxOffices = MutableStateFlow(emptyList<BoxOfficeEntity>())
    val dailyBoxOffices: StateFlow<List<BoxOfficeEntity>> get() = _dailyBoxOffices

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
                }
                is Result.Fail -> {
                    onError(result.exception.message)
                }
            }
            stopLoading()
        }
    }

    sealed class Action {
        object Save: Action()
    }
}