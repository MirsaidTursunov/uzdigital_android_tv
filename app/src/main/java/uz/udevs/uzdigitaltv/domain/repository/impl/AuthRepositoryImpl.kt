package uz.udevs.uzdigitaltv.domain.repository.impl

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import uz.udevs.uzdigitaltv.data.model.ResultData
import uz.udevs.uzdigitaltv.data.model.request.LoginRequest
import uz.udevs.uzdigitaltv.data.remote.AuthApi
import uz.xsoft.moodvi.data.model.request.RegisterRequest
import uz.xsoft.moodvi.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(private val authApi: AuthApi) : AuthRepository {

    override fun login(userName: String, password: String): Flow<ResultData<Unit>> {
        return flow {
//            val response = authApi.login(userName, password)
            val response = authApi.login(LoginRequest(userName, password))
            if (response.isSuccessful) {
                emit(ResultData.Success(Unit))
            } else {
                emit(ResultData.Message(message = "connection error"))
            }

        }.catch {
            emit(ResultData.Fail(it))
        }.flowOn(Dispatchers.IO)
    }

    override fun register(name: String, password: String, email: String) = flow {
        Log.d("FFFFF", "register: ")
        val response = authApi.createUser(RegisterRequest(name, password, email))
        if (response.isSuccessful) {
            emit(ResultData.Success(Unit))
        } else {
            if (response.body() != null) {
                if (response.body()!!.error.usernameError.isNotEmpty())
                    emit(ResultData.Message(response.body()!!.error.usernameError[0]))
                else if (response.body()!!.error.passwordError.isNotEmpty()){
                    emit(ResultData.Message(response.body()!!.error.passwordError[0]))
                }else{
                    emit(ResultData.Message(message = "connection error"))
                }
            }
        }
    }.catch {
        Log.d("FFFF", "register: error $it ")
        emit(ResultData.Fail(it))
    }.flowOn(Dispatchers.IO)

}
