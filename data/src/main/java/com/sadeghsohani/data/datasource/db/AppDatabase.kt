package com.sadeghsohani.data.datasource.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sadeghsohani.domain.models.entities.UserEntity

//version must be 1 ore more , not 0
@Database(
    entities = [UserEntity :: class] ,
    version = 1
)
abstract class AppDatabase() : RoomDatabase() {

    abstract fun getUserDao(): UserDao

    companion object {

        @Volatile
        private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { it ->
                instance = it
            }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                "MyDatabase.db"
            ).allowMainThreadQueries().build()


    }

}