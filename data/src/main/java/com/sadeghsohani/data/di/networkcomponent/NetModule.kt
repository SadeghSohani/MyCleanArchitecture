package com.sadeghsohani.data.di.networkcomponent

import com.sadeghsohani.data.datasource.network.MyApi
import com.sadeghsohani.data.datasource.network.NetworkConnectionInterceptor
import dagger.Lazy
import dagger.Module
import dagger.Provides
import okhttp3.Call
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
object NetModule{

    @NetworkScope
    @Provides
    @JvmStatic
    fun http(
        connectionInterceptor: NetworkConnectionInterceptor
    ) : OkHttpClient {
        return OkHttpClient.Builder()
             .addInterceptor(connectionInterceptor)
             .build()
    }

    @NetworkScope
    @Provides
    @JvmStatic
    fun myApi(httpClient: Lazy<OkHttpClient>) : MyApi {
        return Retrofit.Builder()
            .callFactory(object : Call.Factory{
                override fun newCall(request: Request): Call =
                    httpClient.get().newCall(request)
            })
            .baseUrl("http://192.168.1.53:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MyApi :: class.java)
    }

}