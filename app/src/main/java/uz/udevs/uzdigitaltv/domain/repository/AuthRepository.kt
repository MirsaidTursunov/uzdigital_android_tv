package uz.xsoft.moodvi.domain.repository

import kotlinx.coroutines.flow.Flow
import uz.udevs.uzdigitaltv.data.model.ResultData

interface AuthRepository {

    fun login(userName : String,password : String) : Flow<ResultData<Unit>>
    fun register(name: String, password: String, email: String): Flow<ResultData<Unit>>
}
