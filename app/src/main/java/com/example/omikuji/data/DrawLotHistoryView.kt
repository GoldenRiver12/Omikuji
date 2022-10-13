package com.example.omikuji.data

import androidx.room.ColumnInfo
import androidx.room.DatabaseView
import java.time.ZonedDateTime

@DatabaseView(
    viewName = "draw_lot_histories_view",
    value = """
SELECT
    dlh.id,
    ld.lot_name,
    dlh.drew_on
FROM draw_lot_histories dlh
JOIN lot_details ld on ld.id = dlh.lot_id
""")
data class DrawLotHistoryView (
    @ColumnInfo(name="id")
    val drawLotHistoryId: Long,
    @ColumnInfo(name = "lot_name")
    val lotName: String,
    @ColumnInfo(name = "drew_on")
    val drewOn: ZonedDateTime
)