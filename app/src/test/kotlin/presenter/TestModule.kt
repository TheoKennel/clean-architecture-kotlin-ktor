package presenter

import di.DaggerAppComponent
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.serialization.gson.*
import presenter.controller.*
import java.text.DateFormat
import java.util.logging.Logger

var isFirebaseInitialized = false

fun Application.testModule() {
    configureSerialization()
    val appComponent = DaggerAppComponent.create()
    if (!isFirebaseInitialized) {
        appComponent.getFirebaseInitialize()
        isFirebaseInitialized = true
    }
    configureCounterRoutes(appComponent)
    configureCustomGetDexRoutes(appComponent)
    configureCustomSaveDexRoutes(appComponent)
    configureDexRoutes(appComponent)
    configureShinyCatch(appComponent)
    configureUserRoutes(appComponent)
}

fun Application.configureSerialization() {
    install(ContentNegotiation) {
        gson {
            setPrettyPrinting()
            setDateFormat(DateFormat.LONG)
            serializeNulls()
        }
    }
}
