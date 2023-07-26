package uz.ruzibekov.starwars_test.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uz.ruzibekov.domain.model.entity.toStarshipEntity
import uz.ruzibekov.domain.model.response.personage.Personage
import uz.ruzibekov.domain.model.response.starship.Starship
import uz.ruzibekov.domain.model.response.starship.toStarship
import uz.ruzibekov.domain.usecase.AddFavoriteStarshipUseCase
import uz.ruzibekov.domain.usecase.GetFavoriteStarshipsUseCase
import uz.ruzibekov.domain.usecase.GetPersonagesByNameUseCase
import uz.ruzibekov.domain.usecase.GetStarshipByNameUseCase
import uz.ruzibekov.domain.usecase.RemoveStarshipFromFavoritesUseCase
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getPersonagesByName: GetPersonagesByNameUseCase,
    private val getStarshipByName: GetStarshipByNameUseCase,
    private val addFavoriteStarship: AddFavoriteStarshipUseCase,
    private val getFavoriteStarships: GetFavoriteStarshipsUseCase,
    private val removeStarshipFromFavorites: RemoveStarshipFromFavoritesUseCase
) : ViewModel() {

    private val _search: MutableState<String> = mutableStateOf("")
    val search: State<String> get() = _search

    val personageList: SnapshotStateList<Personage> = mutableStateListOf()
    val starshipList: SnapshotStateList<Starship> = mutableStateListOf()

    val personageFavoriteList: SnapshotStateList<Personage> = mutableStateListOf()
    val starshipFavoriteList: SnapshotStateList<Starship> = mutableStateListOf()

    private val scope = CoroutineScope(Dispatchers.IO)

    fun fetchFavoritesList() {
        scope.launch {
            val list = getFavoriteStarships.getStarships()
            starshipFavoriteList.apply {
                clear()
                list.forEach { starshipFavoriteList.add(it.toStarship()) }
            }
        }
    }

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

    fun isStarshipFavorite(starship: Starship): Boolean {
        return starshipFavoriteList.any { it == starship }
    }

    fun addFavoriteStarship(starship: Starship) {
        if (isStarshipFavorite(starship).not())
            scope.launch {
                addFavoriteStarship.addStarship(starship.toStarshipEntity())
            }
    }

    fun removeFavoriteStarship(starship: Starship) {
        scope.launch {
            removeStarshipFromFavorites.removeStarship(starship)
        }
    }

}