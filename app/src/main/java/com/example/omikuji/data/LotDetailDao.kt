package com.example.omikuji.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface LotDetailDao {
    @Query("SELECT * FROM lot_details")
    fun getLotDetails(): Flow<List<LotDetail>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(lotDetails: List<LotDetail>)
}