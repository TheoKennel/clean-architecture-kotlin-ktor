package presenter.controller

import di.AppComponent
import di.DaggerAppComponent
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.routing.*

fun main() {
    embeddedServer(Netty, port = 8080, module = Application::module).start(wait = true)
}

fun Application.module() {
    val appComponent = DaggerAppComponent.create()
    configureCounterRoutes(appComponent)
    configureCustomGetDexRoutes(appComponent)
    configureCustomSaveDexRoutes(appComponent)
    configureDexRoutes(appComponent)
    configureShinyCatch(appComponent)
    configureUserRoutes(appComponent)
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

            get("/{id}/first-filter-list") {
                controller.getFirstFilterList(call)
            }

            get("/{id}/pkm-catch") {
                controller.getPkmCatch(call)
            }

            get("/{id}/pkm-list") {
                controller.getPkmList(call)
            }

            get("/{id}/second-filter-list") {
                controller.getSecondFilterList(call)
            }
        }
    }
}

fun Application.configureCustomSaveDexRoutes(appComponent: AppComponent) {
    val controller = appComponent.getCustomSaveDexController()
    routing {
        route("/custom-dex/save") {

            patch("/name/{id}") {
                controller.saveCustomDexName(call)
            }

            patch("/first-filter/{id}") {
                controller.saveFirstFilterList(call)
            }

            patch("/pkm-catch/{id}") {
                controller.savePkmCatch(call)
            }

            patch("/pkm-list/{id}") {
                controller.savePkmList(call)
            }

            patch("/second-filter-list/{id}") {
                controller.saveSecondFilterList(call)
            }

            patch("/second-filter-name/{id}") {
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

            delete("/{id}") {
                controller.deleteShiny(call)
            }

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
