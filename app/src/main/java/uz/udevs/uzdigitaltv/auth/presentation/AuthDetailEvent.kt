package uz.udevs.uzdigitaltv.auth.presentation

sealed interface AuthDetailEvent{
    data class PhoneNumberChanged(val value: Int): AuthDetailEvent
}