package com.sadeghsohani.data.datasource.network

import com.sadeghsohani.domain.models.responses.ServerMsgResponse
import retrofit2.Response
import retrofit2.http.*
import javax.inject.Inject

interface MyApi {

    @FormUrlEncoded
    @POST("sendPhone")
    suspend fun getMsg(
        @Field("phone") phone: String
    ) : Response<ServerMsgResponse>

}