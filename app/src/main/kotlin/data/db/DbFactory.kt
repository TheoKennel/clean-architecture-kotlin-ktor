package data.db

import data.db.firebase.handleFirebaseOperationWithErrorCode
import java.util.*

internal class DbFactory {
    fun getDatabase(db : String) {
        return when (db.lowercase(Locale.getDefault())) {
            is "firebase" -> handleFirebaseOperationWithErrorCode {  }
            is "postgre" -> null
        }
    }
}