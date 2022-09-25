package com.example.omikuji.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface DrawLotHistoryDao {

    @Query("SELECT * FROM draw_lot_histories")
    fun getDrawLotHistories(): Flow<DrawLotHistory>

    @Insert
    fun insertDrawLotHistory(drawLotHistory: DrawLotHistory)
}