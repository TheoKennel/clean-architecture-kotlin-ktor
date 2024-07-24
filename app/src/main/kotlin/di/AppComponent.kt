package di

import dagger.Component
import data.db.firebase.FirebaseInitializer
import di.domain.*
import presenter.controller.counters.CounterImpl
import presenter.controller.custom_dex.CustomGetDexImpl
import presenter.controller.custom_dex.CustomSaveDexImpl
import presenter.controller.dex.DexImpl
import presenter.controller.shiny_catch.ShinyImpl
import presenter.controller.user.UserImpl
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        CountersDomainModule::class,
        CustomDexGetModule::class,
        CustomDexSaveModule::class,
        DexModule::class,
        ShinyCatchModule::class,
        UserModule::class,
        RepositoryDataModule::class
    ]
)
interface AppComponent {
    fun getCounterController(): CounterImpl
    fun getCustomGetDexController(): CustomGetDexImpl
    fun getCustomSaveDexController(): CustomSaveDexImpl
    fun getDexController(): DexImpl
    fun getShinyController(): ShinyImpl
    fun getUserController(): UserImpl
    fun getFirebaseInitialize(): FirebaseInitializer
}