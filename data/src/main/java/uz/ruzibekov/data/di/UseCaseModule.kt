package uz.ruzibekov.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.ruzibekov.data.repository.StarWarsRepository
import uz.ruzibekov.domain.usecase.GetPersonagesByNameUseCase
import uz.ruzibekov.domain.usecase.GetStarshipByNameUseCase

@Module
@InstallIn(SingletonComponent::class)
interface UseCaseModule {

    @Binds
    fun bindToStarWarsRepository1(repository: StarWarsRepository): GetPersonagesByNameUseCase

    @Binds
    fun bindToStarWarsRepository2(repository: StarWarsRepository): GetStarshipByNameUseCase
}