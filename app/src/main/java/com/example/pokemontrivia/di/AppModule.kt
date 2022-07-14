package com.example.pokemontrivia.di

import com.example.pokemontrivia.core.Constants
import com.example.pokemontrivia.datasource.remote.PokemonAPI
import com.example.pokemontrivia.repository.PokemonRepository
import com.example.pokemontrivia.repository.PokemonRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providePokemonAPI(): PokemonAPI {
        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL)
            .build().create(PokemonAPI::class.java)
    }

    @Singleton
    @Provides
    fun providePokemonRepository(api : PokemonAPI) : PokemonRepository{
        return PokemonRepositoryImpl(api)
    }

}