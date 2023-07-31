package uz.udevs.uzdigitaltv.utils.navigation

import uz.udevs.uzdigitaltv.utils.AppScreen


interface Navigator {
    suspend fun navigateTo(screen: AppScreen)
    suspend fun back()
}