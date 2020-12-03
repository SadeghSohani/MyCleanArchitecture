package com.sadeghsohani.data.di.databasecomponent

import com.sadeghsohani.data.datasource.db.AppDatabase
import com.sadeghsohani.data.di.contextcomponent.ContextComponent
import dagger.Component
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class DatabaseScope

@DatabaseScope
@Component(
    dependencies = [ContextComponent::class],
    modules = [DatabaseModule::class]
)
interface DatabaseComponent {

    fun provideDatabase() : AppDatabase

}