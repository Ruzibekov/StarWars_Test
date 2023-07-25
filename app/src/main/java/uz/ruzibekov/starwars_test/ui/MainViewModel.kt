package uz.ruzibekov.starwars_test.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.ruzibekov.domain.model.personage.Personage
import uz.ruzibekov.domain.usecase.GetPersonagesByNameUseCase
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getPersonagesByName: GetPersonagesByNameUseCase
) : ViewModel() {

    private val _search: MutableState<String> = mutableStateOf("")
    val search: State<String> get() = _search

    val personageList: SnapshotStateList<Personage> = mutableStateListOf()

    val state = MainState()

    fun search(text: String) {
        _search.value = text

        if (text.length > 1) {
            viewModelScope.launch {

                getPersonagesByName.getPersonages(text).collect { response ->
                    personageList.apply {
                        clear()
                        addAll(response.personages)
                    }
                }
            }
        }
    }
}