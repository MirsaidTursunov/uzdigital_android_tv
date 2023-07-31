package uz.udevs.uzdigitaltv.data.remote

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import uz.udevs.uzdigitaltv.data.model.request.LoginRequest
import uz.xsoft.moodvi.data.model.request.RegisterRequest
import uz.udevs.uzdigitaltv.data.model.response.LoginResponse
import uz.udevs.uzdigitaltv.data.model.response.RegisterResponse

interface AuthApi {

    @POST("auth/token/login/")
    suspend fun login(
        @Body loginRequest: LoginRequest
    ): Response<LoginResponse>

    @POST("auth/users/")
    suspend fun createUser(
        @Body registerRequest: RegisterRequest
    ): Response<RegisterResponse>

}