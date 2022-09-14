package com.example.omikuji.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.ZonedDateTime

@Entity(tableName = "draw_lot_histories")
data class DrawLotHistory(
    @ColumnInfo(name = "lot_id")
    val lotId: Int,

    @ColumnInfo(name = "drew_on")
    val drewOn: ZonedDateTime
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}