package data.db.postgre

import data.db.db_repository.*
import data.db.factory.RepositoryFactory

class SqlRepositoryFactory : RepositoryFactory {

    override fun createCounterRepository(): CountersRepository {
        TODO("Not yet implemented")
    }

    override fun createCustomDexRepository(): CustomDexRepository {
        TODO("Not yet implemented")
    }

    override fun createDexRepository(): DexRepository {
        TODO("Not yet implemented")
    }

    override fun createShinyRepository(): ShinyRepository {
        TODO("Not yet implemented")
    }

    override fun createUserRepository(): UserRepository {
        TODO("Not yet implemented")
    }
}
