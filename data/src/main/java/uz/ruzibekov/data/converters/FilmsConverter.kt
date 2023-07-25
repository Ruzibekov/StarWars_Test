package uz.ruzibekov.data.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


class FilmsConverter {

    @TypeConverter
    fun fromList(films: List<String>): String {
        val gson = Gson()
        val type: Type = object : TypeToken<List<String>>() {}.type
        return gson.toJson(films, type)
    }

    @TypeConverter
    fun toList(films: String): List<String> {
        val gson = Gson()
        val type: Type = object : TypeToken<List<String>>() {}.type
        return gson.fromJson(films, type)
    }

}