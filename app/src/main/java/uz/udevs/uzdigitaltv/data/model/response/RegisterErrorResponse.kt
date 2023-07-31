package uz.udevs.uzdigitaltv.data.model.response

import com.google.gson.annotations.SerializedName

data class RegisterErrorResponse(
    @SerializedName("password")
    val passwordError: List<String>,
    @SerializedName("username")
    val usernameError: List<String>
)
