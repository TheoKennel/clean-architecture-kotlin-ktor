package data.db.factory

import data.db.db_repository.*

interface RepositoryFactory {
    fun createCounterRepository(): CountersRepository
    fun createCustomDexRepository(): CustomDexRepository
    fun createDexRepository(): DexRepository
    fun createShinyRepository(): ShinyRepository
    fun createUserRepository(): UserRepository
}
