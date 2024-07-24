package di.domain

import dagger.Module
import dagger.Provides
import data.domain_impl_repository.ShinyRepositoryImpl
import domain.use_cases.shiny_catch.GetShiny
import domain.use_cases.shiny_catch.GetShinyImpl
import domain.use_cases.shiny_catch.SaveOrUpdateShiny
import domain.use_cases.shiny_catch.SaveOrUpdateShinyImpl
import javax.inject.Singleton

@Module
internal class ShinyCatchModule {

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