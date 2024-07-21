package di.domain

import dagger.Module
import dagger.Provides
import data.repository.ShinyRepositoryImpl
import domain.use_cases.shiny_catch.*
import domain.use_cases.shiny_catch.DeleteShinyImpl
import domain.use_cases.shiny_catch.GetShinyImpl
import javax.inject.Singleton

@Module
internal class ShinyCatchModule {

    @Provides
    @Singleton
    fun provideDeleteShiny(
        repository: ShinyRepositoryImpl,
    ) : DeleteShiny {
        return DeleteShinyImpl(repository)
    }

    @Provides
    @Singleton
    fun provideGetShiny(
        repository: ShinyRepositoryImpl,
    ) : GetShiny {
        return GetShinyImpl(repository)
    }

    @Provides
    @Singleton
    fun provideSaveShiny(
        repository: ShinyRepositoryImpl,
    ) : SaveOrUpdateShiny {
        return SaveOrUpdateShinyImpl(repository)
    }
}