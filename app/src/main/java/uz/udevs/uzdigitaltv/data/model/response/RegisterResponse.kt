package uz.udevs.uzdigitaltv.data.model.response


data class RegisterResponse(
    val error : RegisterErrorResponse,
    val success : RegisterSuccess
)