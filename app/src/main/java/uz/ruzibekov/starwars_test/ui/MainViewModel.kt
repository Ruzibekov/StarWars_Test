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
import uz.ruzibekov.domain.model.entity.personage.toPersonageEntity
import uz.ruzibekov.domain.model.entity.starship.toStarshipEntity
import uz.ruzibekov.domain.model.response.personage.Personage
import uz.ruzibekov.domain.model.response.personage.toPersonage
import uz.ruzibekov.domain.model.response.starship.Starship
import uz.ruzibekov.domain.model.response.starship.toStarship
import uz.ruzibekov.domain.usecase.personage.AddFavoritePersonageUseCase
import uz.ruzibekov.domain.usecase.personage.GetFavoritePersonageUseCase
import uz.ruzibekov.domain.usecase.personage.GetPersonagesByNameUseCase
import uz.ruzibekov.domain.usecase.personage.RemovePersonageFromFavoritesUseCase
import uz.ruzibekov.domain.usecase.starship.AddFavoriteStarshipUseCase
import uz.ruzibekov.domain.usecase.starship.GetFavoriteStarshipsUseCase
import uz.ruzibekov.domain.usecase.starship.GetStarshipByNameUseCase
import uz.ruzibekov.domain.usecase.starship.RemoveStarshipFromFavoritesUseCase
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getPersonagesByName: GetPersonagesByNameUseCase,
    private val getStarshipByName: GetStarshipByNameUseCase,

    private val addFavoritePersonage: AddFavoritePersonageUseCase,
    private val getFavoritePersonages: GetFavoritePersonageUseCase,
    private val removePersonageFromFavorites: RemovePersonageFromFavoritesUseCase,

    private val addFavoriteStarship: AddFavoriteStarshipUseCase,
    private val getFavoriteStarships: GetFavoriteStarshipsUseCase,
    private val removeStarshipFromFavorites: RemoveStarshipFromFavoritesUseCase,
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

            val personages = getFavoritePersonages.getPersonages()
            personageFavoriteList.apply {
                clear()
                personages.forEach { add(it.toPersonage()) }
            }

            val list = getFavoriteStarships.getStarships()
            starshipFavoriteList.apply {
                clear()
                list.forEach { add(it.toStarship()) }
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

    fun personageIsFavorite(data: Personage): Boolean {
        return personageFavoriteList.any { it == data }
    }

    fun addFavoritePersonage(data: Personage) {
        if (personageIsFavorite(data).not())
            scope.launch {
                addFavoritePersonage.addPersonage(data.toPersonageEntity())
            }
    }

    fun removeFavoritePersonage(data: Personage) {
        scope.launch {
            removePersonageFromFavorites.removePersonage(data)
        }
    }


    fun starshipIsFavorite(starship: Starship): Boolean {
        return starshipFavoriteList.any { it == starship }
    }

    fun addFavoriteStarship(starship: Starship) {
        if (starshipIsFavorite(starship).not())
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