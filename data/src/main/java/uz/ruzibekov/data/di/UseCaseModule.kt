package uz.ruzibekov.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.ruzibekov.data.repository.LocalRepository
import uz.ruzibekov.data.repository.RemoteRepository
import uz.ruzibekov.domain.usecase.AddFavoriteStarshipUseCase
import uz.ruzibekov.domain.usecase.GetFavoriteStarshipsUseCase
import uz.ruzibekov.domain.usecase.GetPersonagesByNameUseCase
import uz.ruzibekov.domain.usecase.GetStarshipByNameUseCase
import uz.ruzibekov.domain.usecase.RemoveStarshipFromFavoritesUseCase

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
}