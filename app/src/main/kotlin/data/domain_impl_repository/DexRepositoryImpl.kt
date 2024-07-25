package data.domain_impl_repository

import data.db.factory.RepositoryFactoryProvider
import domain.models.Dex
import domain.use_cases.dex.GetDexImpl
import domain.use_cases.dex.SaveOrUpdateMainDexImpl
import utils.Constants

internal class DexRepositoryImpl :
    GetDexImpl.DexRepository,
    SaveOrUpdateMainDexImpl.DexRepository
{
    private val repositoryFactory = RepositoryFactoryProvider.getFactory(Constants.DATABASE)
    private val repository = repositoryFactory.createDexRepository()

    override suspend fun get(userId: String) : Dex = repository.get(userId)

    override suspend fun save(userId: String, dex: Dex) = repository.saveOrUpdate(userId, dex)
}