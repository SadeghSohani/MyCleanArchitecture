package com.sadeghsohani.mycleanarchitecture.ui.mainactivity

import com.sadeghsohani.data.repositories.ServerMsgRepository
import com.sadeghsohani.data.repositories.UserRepository
import com.sadeghsohani.domain.usecases.GetUserFromDb
import com.sadeghsohani.domain.usecases.SaveUserInDb
import com.sadeghsohani.domain.usecases.ServerMessage
import dagger.Module
import dagger.Provides

@Module
object MainModule {

    @Provides
    @JvmStatic
    fun serverMsgUseCase(repo: ServerMsgRepository) : ServerMessage = ServerMessage(repo)

    @Provides
    @JvmStatic
    fun saveUserInDbUseCase(repo: UserRepository) : SaveUserInDb = SaveUserInDb(repo)

    @Provides
    @JvmStatic
    fun getUserFromDbUseCase(repo: UserRepository) : GetUserFromDb = GetUserFromDb(repo)

//    @Provides
//    @JvmStatic
//    fun useCases(
//        serverMessage: ServerMessage,
//        saveUserInDb: SaveUserInDb,
//        getUserFromDb: GetUserFromDb
//    ) : UseCases = UseCases(
//            serverMessage,
//            saveUserInDb,
//            getUserFromDb
//    )

}