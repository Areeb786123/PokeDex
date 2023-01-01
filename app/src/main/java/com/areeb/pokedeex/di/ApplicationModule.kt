package com.areeb.pokedeex.di

import com.areeb.pokedeex.data.RemoteDataSource
import com.areeb.pokedeex.data.network.remote.api.HomeApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @Singleton
    @Provides
    fun providesHomeApi(
        remoteDataSource: RemoteDataSource
    ): HomeApi {
        return remoteDataSource.buildApi(
            HomeApi::class.java,
            "https://raw.githubusercontent.com/Biuni/PokemonGO-Pokedex/master/"
        )
    }
}
