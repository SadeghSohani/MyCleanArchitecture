package com.sadeghsohani.mycleanarchitecture.ui.mainactivity

import com.sadeghsohani.data.di.databasecomponent.DatabaseComponent
import com.sadeghsohani.data.di.networkcomponent.NetworkComponent
import com.sadeghsohani.domain.usecases.GetUserFromDb
import com.sadeghsohani.domain.usecases.SaveUserInDb
import com.sadeghsohani.domain.usecases.ServerMessage
import dagger.Component
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class AppScope

@AppScope
@Component(
    modules = [MainModule::class] ,
    dependencies = [NetworkComponent::class , DatabaseComponent ::class]
)
interface AppComponent  {

    fun provideServerMessageUseCase() : ServerMessage
    fun provideSaveUserInDbUseCase() : SaveUserInDb
    fun provideGetUserFromDbUseCase() : GetUserFromDb

    fun provideViewModel() : MainViewModel

    fun inject(activity: MainActivity)

}