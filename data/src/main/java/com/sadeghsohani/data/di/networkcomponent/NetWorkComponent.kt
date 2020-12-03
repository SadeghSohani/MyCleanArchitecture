package com.sadeghsohani.data.di.networkcomponent

import com.sadeghsohani.data.datasource.network.MyApi
import com.sadeghsohani.data.di.contextcomponent.ContextComponent
import dagger.Component
import okhttp3.OkHttpClient
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class NetworkScope

@NetworkScope
@Component(
    dependencies = [ContextComponent::class],
    modules = [NetModule::class]
)

interface NetworkComponent {

    fun provideOkHttp(): OkHttpClient
    fun provideRetrofit(): MyApi

}