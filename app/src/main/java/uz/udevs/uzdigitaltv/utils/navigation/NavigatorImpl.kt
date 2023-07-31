package uz.udevs.uzdigitaltv.utils.navigation

import cafe.adriel.voyager.androidx.AndroidScreen
import kotlinx.coroutines.flow.MutableSharedFlow
import uz.udevs.uzdigitaltv.utils.AppNavigation
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NavigatorImpl @Inject constructor() : Navigator, NavigationDispatcher {
    override val dispatcher = MutableSharedFlow<AppNavigation>()

    private suspend fun navigate(screen: AppNavigation){
        dispatcher.emit(screen)
    }

    override suspend fun navigateTo(screen: AndroidScreen) = navigate {
        push(screen)
    }

    override suspend fun back() = navigate {
        pop()
    }
}