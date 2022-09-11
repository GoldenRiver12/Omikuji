package com.example.omikuji.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface LotDetailsDao {
    @Query("SELECT * FROM LotDetails")
    fun getLotDetails(): Flow<List<LotDetails>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(lotDetails: List<LotDetails>)
}