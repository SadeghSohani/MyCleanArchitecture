package com.sadeghsohani.data.datasource.network

import org.json.JSONException
import org.json.JSONObject
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

class SafeApiRequest @Inject constructor() {

    suspend fun<T:Any> request(call : suspend() -> Response<T>) : T {

        val response = call.invoke()
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            val error = response.errorBody()?.string()

            val message = StringBuilder()
            error?.let {

                try {
                    message.append(JSONObject(it).getString("message"))
                }catch (err: JSONException) {}
                message.append("\n")

            }

            message.append("Error code : ${response.code()}")

            throw IOException(message.toString())
        }

    }

}