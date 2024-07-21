package data.repository

import domain.error.ErrorHandler
import domain.models.Dex
import domain.use_cases.dex.GetDexImpl
import domain.use_cases.dex.SaveOrUpdateMainDexImpl
import utils.UtilsResult

internal class DexRepositoryImpl() :
    GetDexImpl.DexRepository,
    SaveOrUpdateMainDexImpl.DexRepository
{
    override suspend fun get(userId: String): UtilsResult<Dex, ErrorHandler> {
        TODO("Not yet implemented")
    }

    override suspend fun save(userId: String, mainDexCatch: List<String>): UtilsResult<Unit, ErrorHandler> {
        TODO("Not yet implemented")
    }
}