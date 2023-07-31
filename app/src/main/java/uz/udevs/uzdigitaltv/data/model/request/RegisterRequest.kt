package uz.xsoft.moodvi.data.model.request

import com.google.gson.annotations.SerializedName

data class RegisterRequest(
    @SerializedName("username")
    val username : String,
    @SerializedName("password")
    val password : String,
    @SerializedName("email")
    val email : String
)