package data.db.firebase

import data.db.db_repository.*
import data.db.factory.RepositoryFactory

internal class FirebaseRepositoryFactory : RepositoryFactory {

    override fun createCounterRepository(): CountersRepository {
        return FirebaseCounterRepoImpl()
    }

    override fun createCustomGetRepository(): CustomGetRepository {
        return FirebaseCustomGetRepoImpl()
    }

    override fun createCustomSaveRepository(): CustomSaveRepository {
        return FirebaseCustomSaveRepoImpl()
    }

    override fun createDexRepository(): DexRepository {
        return FirebaseDexRepoImpl()
    }

    override fun createShinyRepository(): ShinyRepository {
        return FirebaseShinyRepoImpl()
    }

    override fun createUserRepository(): UserRepository {
        return FirebaseUserRepoImpl()
    }
}