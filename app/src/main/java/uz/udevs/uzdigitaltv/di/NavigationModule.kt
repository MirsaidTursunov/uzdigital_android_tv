package uz.udevs.uzdigitaltv.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.udevs.uzdigitaltv.utils.navigation.NavigationDispatcher
import uz.udevs.uzdigitaltv.utils.navigation.Navigator
import uz.udevs.uzdigitaltv.utils.navigation.NavigatorImpl

@Module
@InstallIn(SingletonComponent::class)
interface NavigationModule {

    @Binds
    fun provideNavigator(impl : NavigatorImpl) : Navigator

    @Binds
    fun provideNavigationDispatcher(impl : NavigatorImpl) : NavigationDispatcher

}