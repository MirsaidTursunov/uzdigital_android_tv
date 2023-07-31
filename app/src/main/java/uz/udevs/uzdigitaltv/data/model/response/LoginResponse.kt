package uz.udevs.uzdigitaltv.data.model.response

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("token")
    val token : String
)