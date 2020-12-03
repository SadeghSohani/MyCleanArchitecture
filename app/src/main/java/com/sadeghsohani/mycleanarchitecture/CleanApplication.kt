package com.sadeghsohani.mycleanarchitecture

import android.app.Application
import com.sadeghsohani.mycleanarchitecture.di.CleanComponent
import com.sadeghsohani.mycleanarchitecture.di.CleanComponentProvider
import com.sadeghsohani.mycleanarchitecture.di.DaggerCleanComponent
import com.sadeghsohani.data.di.contextcomponent.DaggerContextComponent
import com.sadeghsohani.data.di.databasecomponent.DaggerDatabaseComponent
import com.sadeghsohani.data.di.networkcomponent.DaggerNetworkComponent

class CleanApplication : Application() , CleanComponentProvider {

    private lateinit var cleanComponent: CleanComponent

    override fun onCreate() {
        super.onCreate()

        val context = DaggerContextComponent.factory().create(this)
        val network = DaggerNetworkComponent.builder().contextComponent(context).build()
        val database = DaggerDatabaseComponent
            .builder()
            .contextComponent(context)
            .build()

        cleanComponent = DaggerCleanComponent
            .factory()
            .create(
                context,
                network,
                database
            )
            .also {
                it.inject(this)
            }

    }

    override fun provideAppComponent(): CleanComponent {
        return cleanComponent
    }


}