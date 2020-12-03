package com.sadeghsohani.data.repositories

import com.sadeghsohani.data.datasource.network.MyApi
import com.sadeghsohani.data.datasource.network.SafeApiRequest
import com.sadeghsohani.data.mappers.ServerMsgMappper
import com.sadeghsohani.domain.models.datamodels.ServerMsgModel
import com.sadeghsohani.domain.repositories.ServerMsgRepo
import javax.inject.Inject

class ServerMsgRepository @Inject constructor(
    private val apiService: MyApi,
    private val shareMapper: ServerMsgMappper,
    private val safeApiRequest: SafeApiRequest
) : ServerMsgRepo {

    override suspend fun getServerMsg(phone: String): ServerMsgModel {
        return  shareMapper.toShareDetails(safeApiRequest.request{ apiService.getMsg(phone) })
    }

}