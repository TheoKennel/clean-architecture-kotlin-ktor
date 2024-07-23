package data.db.factory

import data.db.db_repository.*

interface RepositoryFactory {
    fun createCounterRepository(): CountersRepository
    fun createCustomGetRepository(): CustomGetRepository
    fun createCustomSaveRepository(): CustomSaveRepository
    fun createDexRepository(): DexRepository
    fun createShinyRepository(): ShinyRepository
    fun createUserRepository(): UserRepository
}
