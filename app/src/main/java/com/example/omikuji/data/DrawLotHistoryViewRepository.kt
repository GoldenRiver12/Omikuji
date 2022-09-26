package com.example.omikuji.data

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DrawLotHistoryViewRepository @Inject constructor(
    val drawLotHistoryViewDao: DrawLotHistoryViewDao
) {
    fun getAllHistoryOrderByDrewOn(): Flow<List<DrawLotHistoryView>> =
        drawLotHistoryViewDao.getAllOrderByDrewOn()
}