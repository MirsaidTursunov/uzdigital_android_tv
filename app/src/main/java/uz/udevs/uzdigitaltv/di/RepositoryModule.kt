package uz.udevs.uzdigitaltv.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.udevs.uzdigitaltv.domain.repository.impl.AuthRepositoryImpl
import uz.xsoft.moodvi.domain.repository.AuthRepository

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindAuthRepository(impl : AuthRepositoryImpl) : AuthRepository
}