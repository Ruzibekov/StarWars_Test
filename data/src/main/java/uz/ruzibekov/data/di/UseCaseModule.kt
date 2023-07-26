package uz.ruzibekov.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.ruzibekov.data.repository.LocalRepository
import uz.ruzibekov.data.repository.RemoteRepository
import uz.ruzibekov.domain.usecase.personage.AddFavoritePersonageUseCase
import uz.ruzibekov.domain.usecase.personage.GetFavoritePersonageUseCase
import uz.ruzibekov.domain.usecase.personage.GetPersonagesByNameUseCase
import uz.ruzibekov.domain.usecase.personage.RemovePersonageFromFavoritesUseCase
import uz.ruzibekov.domain.usecase.starship.AddFavoriteStarshipUseCase
import uz.ruzibekov.domain.usecase.starship.GetFavoriteStarshipsUseCase
import uz.ruzibekov.domain.usecase.starship.GetStarshipByNameUseCase
import uz.ruzibekov.domain.usecase.starship.RemoveStarshipFromFavoritesUseCase

@Module
@InstallIn(SingletonComponent::class)
interface UseCaseModule {

    @Binds
    fun bindToStarWarsRepository1(repository: RemoteRepository): GetPersonagesByNameUseCase

    @Binds
    fun bindToStarWarsRepository2(repository: RemoteRepository): GetStarshipByNameUseCase

    @Binds
    fun bindToFavoritesRepository1(repository: LocalRepository): AddFavoriteStarshipUseCase

    @Binds
    fun bindToFavoritesRepository2(repository: LocalRepository): GetFavoriteStarshipsUseCase

    @Binds
    fun bindToFavoritesRepository3(repository: LocalRepository): RemoveStarshipFromFavoritesUseCase

    @Binds
    fun bindToFavoritesRepository4(repository: LocalRepository): AddFavoritePersonageUseCase

    @Binds
    fun bindToFavoritesRepository5(repository: LocalRepository): GetFavoritePersonageUseCase

    @Binds
    fun bindToFavoritesRepository6(repository: LocalRepository): RemovePersonageFromFavoritesUseCase
}