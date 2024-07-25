package presenter.it

import com.google.gson.Gson
import domain.models.Dex
import domain.models.User
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.gson.*
import io.ktor.server.testing.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import presenter.testModule
import java.text.DateFormat
import kotlin.test.assertEquals

class CounterRouteTest {

    private val gson = Gson()

    @Test
    fun testGetUserById() = testApplication {
        application {
            testModule()
        }

        val client = createClient {
            install(ContentNegotiation) {
                gson {
                    setPrettyPrinting()
                    setDateFormat(DateFormat.LONG)
                    serializeNulls()
                }
            }
        }

        val response = client.get("/user/ak")
        assertEquals(HttpStatusCode.OK, response.status)
    }

    @Test
    fun testSaveUser() = testApplication {
        application {
            testModule()
        }

        val client = createClient {
            install(ContentNegotiation) {
                gson {
                    setPrettyPrinting()
                    setDateFormat(DateFormat.LONG)
                    serializeNulls()
                }
            }
        }

        val user = User("TestUser", listOf(), Dex(listOf(), listOf()), listOf(), "testId")
        val requestBody = gson.toJson(user)
        val response = client.post("/user") {
            contentType(ContentType.Application.Json)
            setBody(requestBody)
        }
        assertEquals(HttpStatusCode.OK, response.status)
    }

    @Test
    fun testSaveUserInvalidData() = testApplication {
        application {
            testModule()
        }

        val client = createClient {
            install(ContentNegotiation) {
                gson {
                    setPrettyPrinting()
                    setDateFormat(DateFormat.LONG)
                    serializeNulls()
                }
            }
        }

        val response = client.post("/user") {
            contentType(ContentType.Application.Json)
            setBody("{}")
        }
        assertEquals(HttpStatusCode.BadRequest, response.status)
    }
}
