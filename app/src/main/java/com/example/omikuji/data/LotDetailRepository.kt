package com.example.omikuji.data

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LotDetailRepository @Inject constructor(
    private val lotDetailDao: LotDetailDao
) {

    fun getLotDetails(): Flow<List<LotDetail>> = lotDetailDao.getLotDetails()

}