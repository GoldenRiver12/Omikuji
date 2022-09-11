package com.example.omikuji.data

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LotDetailsRepository @Inject constructor(
    private val lotDetailsDao: LotDetailsDao
) {

    fun getLotDetails(): Flow<List<LotDetails>> = lotDetailsDao.getLotDetails()

}