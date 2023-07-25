package uz.ruzibekov.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.ruzibekov.data.repository.StarWarsRepository
import uz.ruzibekov.domain.usecase.GetPersonagesByNameUseCase

@Module
@InstallIn(SingletonComponent::class)
interface UseCaseModule {

    @Binds
    fun bindToStarWarsRepository1(repository: StarWarsRepository): GetPersonagesByNameUseCase
}