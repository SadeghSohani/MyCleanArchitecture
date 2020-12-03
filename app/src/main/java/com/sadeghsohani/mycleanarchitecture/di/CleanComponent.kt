package com.sadeghsohani.mycleanarchitecture.di

import com.sadeghsohani.mycleanarchitecture.CleanApplication
import com.sadeghsohani.data.di.contextcomponent.ContextComponent
import com.sadeghsohani.data.di.databasecomponent.DatabaseComponent
import com.sadeghsohani.data.di.networkcomponent.NetworkComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component
interface CleanComponent  {

    fun provideContextComponent(): ContextComponent
    fun provideNetworkComponent(): NetworkComponent
    fun provideDatabaseComponent(): DatabaseComponent

    fun inject(app: CleanApplication)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance
            context : ContextComponent,
            @BindsInstance
            network : NetworkComponent,
            @BindsInstance
            database : DatabaseComponent
        ): CleanComponent
    }

}