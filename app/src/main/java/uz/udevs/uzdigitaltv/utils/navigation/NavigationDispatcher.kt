package uz.udevs.uzdigitaltv.utils.navigation

import kotlinx.coroutines.flow.SharedFlow
import uz.udevs.uzdigitaltv.utils.AppNavigation

interface NavigationDispatcher {
    val dispatcher : SharedFlow<AppNavigation>
}
