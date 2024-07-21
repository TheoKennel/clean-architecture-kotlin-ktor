package data.repository

import domain.error.ErrorHandler
import domain.models.CustomDex
import domain.use_cases.custom_dex.get.*
import domain.use_cases.custom_dex.get.GetCustomDexImpl
import domain.use_cases.custom_dex.get.GetFirstFilterListImpl
import utils.UtilsResult

internal class CustomDexGetRepositoryImpl() :
    GetCustomDexImpl.CustomDexRepository,
    GetFirstFilterListImpl.CustomDexRepository,
    GetPkmCatchImpl.CustomDexRepository,
    GetPkmListImpl.CustomDexRepository,
    GetSecondFilterListImpl.CustomDexRepository
{
    override suspend fun get(userId: String): UtilsResult<CustomDex, ErrorHandler> {
        TODO("Not yet implemented")
    }

    override suspend fun getFirstFilter(userId: String): UtilsResult<List<String>, ErrorHandler> {
        TODO("Not yet implemented")
    }

    override suspend fun getPkmCatch(userId: String): UtilsResult<List<String>, ErrorHandler> {
        TODO("Not yet implemented")
    }

    override suspend fun getPkmList(userId: String): UtilsResult<List<String>, ErrorHandler> {
        TODO("Not yet implemented")
    }

    override suspend fun getSecondFilterList(userId: String): UtilsResult<List<String>, ErrorHandler> {
        TODO("Not yet implemented")
    }
}