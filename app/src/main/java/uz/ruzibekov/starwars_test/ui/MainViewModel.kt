package uz.ruzibekov.starwars_test.ui

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.ruzibekov.domain.usecase.GetPersonagesByNameUseCase
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getPersonagesByName: GetPersonagesByNameUseCase
) : ViewModel() {

    private val _search: MutableState<String> = mutableStateOf("")
    val search: State<String> = _search

    val state = MainState()

    fun setSearchText(text: String) {
        _search.value = text

        if (text.length >= 2) {
            viewModelScope.launch {
                getPersonagesByName.getPersonages(text).collect { response ->
                    Log.i("RRR", "getPersonagesByName = $response")
                }
            }
        }
    }
}