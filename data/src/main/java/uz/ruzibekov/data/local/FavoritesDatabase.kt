package uz.ruzibekov.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import uz.ruzibekov.data.converters.FilmsConverter
import uz.ruzibekov.domain.model.entity.personage.PersonageEntity
import uz.ruzibekov.domain.model.entity.starship.StarshipEntity

@Database(entities = [StarshipEntity::class, PersonageEntity::class], version = 1)
@TypeConverters(value = [FilmsConverter::class, ])
abstract class FavoritesDatabase : RoomDatabase() {

    abstract fun favoritesDao(): FavoritesDao
}