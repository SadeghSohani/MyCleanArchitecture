package com.sadeghsohani.data.di.databasecomponent

import android.content.Context
import com.sadeghsohani.data.datasource.db.AppDatabase
import dagger.Module
import dagger.Provides

@Module
object DatabaseModule {

    @Provides
    @JvmStatic
    fun appDataBase(context: Context) : AppDatabase = AppDatabase(context)

}