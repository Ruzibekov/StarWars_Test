package uz.ruzibekov.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.ruzibekov.data.repository.FavoritesRepository
import uz.ruzibekov.data.repository.StarWarsRepository
import uz.ruzibekov.domain.usecase.AddFavoriteStarshipUseCase
import uz.ruzibekov.domain.usecase.GetFavoriteStarshipsUseCase
import uz.ruzibekov.domain.usecase.GetPersonagesByNameUseCase
import uz.ruzibekov.domain.usecase.GetStarshipByNameUseCase

@Module
@InstallIn(SingletonComponent::class)
interface UseCaseModule {

    @Binds
    fun bindToStarWarsRepository1(repository: StarWarsRepository): GetPersonagesByNameUseCase

    @Binds
    fun bindToStarWarsRepository2(repository: StarWarsRepository): GetStarshipByNameUseCase

    @Binds
    fun bindToFavoritesRepository1(repository: FavoritesRepository): AddFavoriteStarshipUseCase

    @Binds
    fun bindToFavoritesRepository2(repository: FavoritesRepository): GetFavoriteStarshipsUseCase
}