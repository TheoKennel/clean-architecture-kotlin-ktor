package presenter.controller

import com.google.gson.JsonDeserializer
import com.google.gson.JsonParseException
import com.google.gson.JsonSyntaxException
import di.AppComponent
import di.DaggerAppComponent
import io.ktor.serialization.gson.*
import io.ktor.http.*
import io.ktor.serialization.gson.gson
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.json.Json

fun main() {
    embeddedServer(Netty, port = 8080, module = Application::module).start(wait = true)
}

fun Application.module() {
    install(StatusPages) {
        exception<JsonSyntaxException> { call, cause ->
            call.respond(HttpStatusCode.BadRequest, "Invalid JSON format: ${cause.localizedMessage}")
        }
        exception<IllegalArgumentException> { call, cause ->
            call.respond(HttpStatusCode.BadRequest, cause.message ?: "Invalid argument")
        }
        exception<Throwable> { call, cause ->
            call.respond(HttpStatusCode.InternalServerError, cause.message ?: "Internal server error")
        }
    }

    val appComponent = DaggerAppComponent.create()
    appComponent.getFirebaseInitialize()
    configureSerialization()
    configureCounterRoutes(appComponent)
    configureCustomGetDexRoutes(appComponent)
    configureCustomSaveDexRoutes(appComponent)
    configureDexRoutes(appComponent)
    configureShinyCatch(appComponent)
    configureUserRoutes(appComponent)
}

fun Application.configureSerialization() {
    install(ContentNegotiation) {
        json(
            Json {
                ignoreUnknownKeys = false
                isLenient = false
                prettyPrint = true
                encodeDefaults = true
            }
        )
    }
}

fun Application.configureCounterRoutes(appComponent: AppComponent) {
    val controller = appComponent.getCounterController()
    routing {
        route("/counters") {

            get("/{id}") {
                controller.getCounter(call)
            }

            patch("/{id}") {
                controller.saveOrUpdateCounter(call)
            }
        }
    }
}

fun Application.configureCustomGetDexRoutes(appComponent: AppComponent) {
    val controller = appComponent.getCustomGetDexController()
    routing {
        route("/custom-dex/get") {

            get("/{id}") {
                controller.getCustomDex(call)
            }

            get("/{id}/{name}") {
                controller.getCustomDexByName(call)
            }

            get("/{id}/{name}/first-filter-list") {
                controller.getFirstFilterList(call)
            }

            get("/{id}/{name}/pkm-catch") {
                controller.getPkmCatch(call)
            }

            get("/{id}/{name}/pkm-list") {
                controller.getPkmList(call)
            }

            get("/{id}/{name}/second-filter-list") {
                controller.getSecondFilterList(call)
            }
        }
    }
}

fun Application.configureCustomSaveDexRoutes(appComponent: AppComponent) {
    val controller = appComponent.getCustomSaveDexController()
    routing {
        route("/custom-dex/save") {

            patch("/name/{id}/{name}") {
                controller.saveCustomDexName(call)
            }

            patch("/first-filter/{id}/{name}") {
                controller.saveFirstFilterList(call)
            }

            patch("/first-filter-name/{id}/{name}") {
                controller.saveFirstFilterListName(call)
            }

            patch("/pkm-catch/{id}/{name}") {
                controller.savePkmCatch(call)
            }

            patch("/pkm-list/{id}/{name}") {
                controller.savePkmList(call)
            }

            patch("/second-filter-list/{id}/{name}") {
                controller.saveSecondFilterList(call)
            }

            patch("/second-filter-name/{id}/{name}") {
                controller.saveSecondFilterName(call)
            }
        }
    }
}


fun Application.configureDexRoutes(appComponent: AppComponent) {
    val controller = appComponent.getDexController()
    routing {
        route("/dex") {

            get("/{id}") {
                controller.getDex(call)
            }

            patch("/{id}") {
                controller.saveMainDex(call)
            }
        }
    }
}

fun Application.configureShinyCatch(appComponent: AppComponent) {
    val controller = appComponent.getShinyController()
    routing {
        route("/shiny") {

            get("/{id}") {
                controller.getShiny(call)
            }

            patch("/{id}") {
                controller.saveShiny(call)
            }
        }
    }
}

fun Application.configureUserRoutes(appComponent: AppComponent) {
    val controller = appComponent.getUserController()
    routing {
        route("/user") {

            delete("/{id}") {
                controller.deleteUser(call)
            }

            get {
                controller.getUsers(call)
            }

            get("/{id}") {
                controller.getUserById(call)
            }

            post {
                controller.save(call)
            }

            patch("/{id}") {
                controller.update(call)
            }
        }
    }
}

fun strictDeserializer(): JsonDeserializer<Any> {
    return JsonDeserializer { json, typeOfT, context ->
        val jsonObject = json.asJsonObject

        val tempObject = context.deserialize<Any>(json, typeOfT)

        val expectedFields = tempObject.javaClass.declaredFields.map { it.name }.toSet()
        val actualFields = jsonObject.keySet()

        val unknownFields = actualFields - expectedFields
        if (unknownFields.isNotEmpty()) {
            throw JsonParseException("Unknown fields: $unknownFields")
        }

        tempObject
    }
}
