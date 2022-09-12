package com.example.omikuji.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "lot_details")
data class LotDetail(
    @ColumnInfo
    val lotName: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}