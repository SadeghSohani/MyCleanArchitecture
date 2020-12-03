package com.sadeghsohani.mycleanarchitecture.ui.mainactivity

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sadeghsohani.domain.models.entities.UserEntity
import com.sadeghsohani.domain.usecases.GetUserFromDb
import com.sadeghsohani.domain.usecases.SaveUserInDb
import com.sadeghsohani.domain.usecases.ServerMessage
import com.sadeghsohani.mycleanarchitecture.utils.Coroutines
import com.sadeghsohani.mycleanarchitecture.utils.coloredToast
import java.io.IOException
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val serverMsg: ServerMessage,
    private val saveInDb: SaveUserInDb,
    private val getUserFromDb: GetUserFromDb
) : ViewModel() {

    var name : String = ""
    var family : String = ""
    val serverMsgLD = MutableLiveData<String>()
    val nameFamilyLD = MutableLiveData<String>()
    val serverErrLD = MutableLiveData<String>()

    fun fetchDataFromServer() {
        Coroutines.main {
            try {
                val serverMessage = serverMsg("09303289854")
                serverMsgLD.postValue(serverMessage.message)
            } catch(e: IOException){
                serverErrLD.postValue("Could'nt to connect to server!")
            }
        }
    }


    fun getFromDbClick(view: View) {
        Coroutines.main {
            val user : UserEntity? = getUserFromDb.invoke()
            if (user?.name == null || user.family == null) {
                nameFamilyLD.postValue("it is not eny user in database!")
            } else {
                nameFamilyLD.postValue(user.name + " " + user.family)
            }
        }
    }

    fun insertToDbClick(view: View) {
        Coroutines.main {
            val userId = saveInDb.invoke(UserEntity(0, name, family))
            view.context.coloredToast("$userId")
        }
    }

}