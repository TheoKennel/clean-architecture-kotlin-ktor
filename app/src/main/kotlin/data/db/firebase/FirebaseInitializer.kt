package data.db.firebase

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import io.github.cdimascio.dotenv.Dotenv
import java.io.FileInputStream
import java.nio.file.Paths

class FirebaseInitializer {

    init {
        initialiseDb()
    }

    private fun initialiseDb() {

        val dotenv = Dotenv.load()
        val databaseSdk = dotenv["FIREBASE_SDK"] ?: throw IllegalArgumentException("FIREBASE_SDK not found")
        val databaseUrl = dotenv["DATABASE_URL"] ?: throw IllegalArgumentException("DATABASE_URL not found")

        val serviceAccount = loadCredentials(databaseSdk)
        val options = FirebaseOptions.builder()
            .setCredentials(serviceAccount)
            .setDatabaseUrl(databaseUrl)
            .build()

        FirebaseApp.initializeApp(options)
    }

    private fun loadCredentials(databaseSdk: String?): GoogleCredentials {
        val absolutePath = Paths.get(databaseSdk).toAbsolutePath().toString()
        return GoogleCredentials.fromStream(FileInputStream(absolutePath))
    }
}