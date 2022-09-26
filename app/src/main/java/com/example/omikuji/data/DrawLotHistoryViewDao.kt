package com.example.omikuji.data

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface DrawLotHistoryViewDao {

    @Query("SELECT * FROM draw_lot_histories_view ORDER BY drew_on")
    fun getAllOrderByDrewOn(): Flow<List<DrawLotHistoryView>>
}