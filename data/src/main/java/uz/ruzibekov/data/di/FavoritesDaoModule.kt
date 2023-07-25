package uz.ruzibekov.data.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import uz.ruzibekov.data.local.FavoritesDao
import uz.ruzibekov.data.local.FavoritesDatabase


@Module
@InstallIn(SingletonComponent::class)
object FavoritesDaoModule {

    @Provides
    fun provideFavoritesDatabase(@ApplicationContext context: Context): FavoritesDatabase =
        Room.databaseBuilder(context, FavoritesDatabase::class.java, "favorites-database").build()

    @Provides
    fun provideFavoritesDao(database: FavoritesDatabase): FavoritesDao = database.favoritesDao()
}