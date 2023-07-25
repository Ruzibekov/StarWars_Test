package uz.ruzibekov.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.ruzibekov.data.remote.StarWarsService

@Module
@InstallIn(SingletonComponent::class)
object StarWarsServiceModule {

    @Provides
    fun provideBaseUrl(): String = "https://swapi.dev/api/"

    @Provides
    fun provideRetrofit(baseUrl: String): Retrofit =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    fun provideStarWarsService(retrofit: Retrofit): StarWarsService =
        retrofit.create(StarWarsService::class.java)
}