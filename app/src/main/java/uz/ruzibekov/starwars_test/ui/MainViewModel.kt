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
import uz.ruzibekov.domain.model.starship.Starship
import uz.ruzibekov.domain.usecase.GetPersonagesByNameUseCase
import uz.ruzibekov.domain.usecase.GetStarshipByNameUseCase
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getPersonagesByName: GetPersonagesByNameUseCase,
    private val getStarshipByName: GetStarshipByNameUseCase
) : ViewModel() {

    private val _search: MutableState<String> = mutableStateOf("")
    val search: State<String> get() = _search

    val personageList: SnapshotStateList<Personage> = mutableStateListOf()
    val starshipList: SnapshotStateList<Starship> = mutableStateListOf()

    val state = MainState()

    fun search(name: String) {
        _search.value = name

        if (name.length > 1) {
            fetchPersonageListByName(name)
            fetchStarshipListByName(name)
        }
    }

    private fun fetchPersonageListByName(name: String) {
        viewModelScope.launch {
            getPersonagesByName.getPersonages(name).collect { response ->

                personageList.apply {
                    clear()
                    addAll(response.personages)
                }
            }
        }
    }

    private fun fetchStarshipListByName(name: String) {
        viewModelScope.launch {
            getStarshipByName.getStarships(name).collect { response ->

                starshipList.apply {
                    clear()
                    addAll(response.starships)
                }
            }
        }
    }

}