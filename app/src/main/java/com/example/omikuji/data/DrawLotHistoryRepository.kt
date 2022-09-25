package com.example.omikuji.data

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DrawLotHistoryRepository @Inject constructor(
    val drawLotHistoryDao: DrawLotHistoryDao
) {
    fun getDrawLotHistories(): Flow<DrawLotHistory> = drawLotHistoryDao.getDrawLotHistories()

    fun saveDrawLotHistory(drawLotHistory: DrawLotHistory) =
        drawLotHistoryDao.insertDrawLotHistory(drawLotHistory)
}