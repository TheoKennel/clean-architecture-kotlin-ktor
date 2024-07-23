package data.db.factory

import data.db.firebase.FirebaseRepositoryFactory
import data.db.postgre.SqlRepositoryFactory
import utils.Constants

object RepositoryFactoryProvider {

    fun getFactory(databaseType: String): RepositoryFactory {
        return when (databaseType) {
            Constants.FIREBASE -> FirebaseRepositoryFactory()
            Constants.SQL -> SqlRepositoryFactory()
            else -> throw IllegalArgumentException("Unknown db, cannot access repository")
        }
    }
}
