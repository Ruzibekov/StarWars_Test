package uz.ruzibekov.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import uz.ruzibekov.data.converters.FilmsConverter
import uz.ruzibekov.domain.model.entity.StarshipEntity

@Database(entities = [StarshipEntity::class], version = 1)
@TypeConverters(value = [FilmsConverter::class, ])
abstract class FavoritesDatabase : RoomDatabase() {

    abstract fun favoritesDao(): FavoritesDao
}