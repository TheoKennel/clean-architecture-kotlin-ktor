package data.db.db_repository

import domain.models.Counter

interface CountersRepository {
    suspend fun get(userId: String) : List<Counter>
    suspend fun save(userId: String, counter:  List<Counter>)
}