package data.db.firebase

import data.db.db_repository.*
import data.db.factory.RepositoryFactory

internal class FirebaseRepositoryFactory : RepositoryFactory {

    override fun createCounterRepository(): CountersRepository {
        return FirebaseCounterRepoImpl()
    }

    override fun createCustomDexRepository(): CustomDexRepository {
        return FirebaseCustomDexRepoImpl()
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
