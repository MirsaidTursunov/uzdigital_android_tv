package uz.udevs.uzdigitaltv.data.model.response

import com.google.gson.annotations.SerializedName

data class RegisterSuccess(
    @SerializedName("username")
    val username : String,
    @SerializedName("id")
    val id : Int,
    @SerializedName("email")
    val email : String
)
