package data.domain_impl_repository

import data.db.factory.RepositoryFactoryProvider
import domain.models.CustomDex
import domain.use_cases.custom_dex.get.GetCustomDexImpl
import domain.use_cases.custom_dex.save.SaveOrUpdateCustomDexImpl
import utils.Constants

internal class CustomDexRepositoryImpl :
    GetCustomDexImpl.CustomDexRepository,
    SaveOrUpdateCustomDexImpl.SaveOrUpdateCustomDexRepository
{
    private val repositoryFactory = RepositoryFactoryProvider.getFactory(Constants.DATABASE)
    private val repository = repositoryFactory.createCustomDexRepository()
    override suspend fun get(userId: String): CustomDex = repository.getCustomDex(userId)

    override suspend fun save(userId: String, customDex: CustomDex) = repository.saveOrUpdateCustomDex(userId, customDex)
}
