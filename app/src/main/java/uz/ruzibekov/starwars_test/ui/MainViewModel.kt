package uz.ruzibekov.starwars_test.ui

import android.util.Log
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

    val state = MainState()

    fun startSearching() {
        val searchText = state.homeState.search.value

        viewModelScope.launch {
//            if (searchText.length >= 2) {
            Log.i("RRR", "started")
            getPersonagesByName.getPersonages("dar"/*searchText*/).collect { response ->
                Log.i("RRR", "getPersonagesByName = $response")
            }
//            }
        }
    }
}