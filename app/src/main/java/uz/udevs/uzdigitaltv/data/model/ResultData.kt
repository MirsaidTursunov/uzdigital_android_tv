package uz.udevs.uzdigitaltv.data.model

import uz.udevs.uzdigitaltv.data.model.model.Message

sealed interface ResultData<T> {
    class Success<T>(data: T) : ResultData<T>
    class Fail<T>(val throwable: Throwable) : ResultData<T>
    class Message<T>(val message : String? = null,val messageId : Int? = null) : ResultData<T>
}

fun <T> ResultData.Message<T>.toMessage() = Message(message,messageId)