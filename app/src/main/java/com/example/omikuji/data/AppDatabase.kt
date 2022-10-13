package com.example.omikuji.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.workDataOf
import com.example.omikuji.utilities.DATABASE_NAME
import com.example.omikuji.utilities.LOT_DETAIL_DATA_FILENAME
import com.example.omikuji.workers.SeedDatabaseWorker
import com.example.omikuji.workers.SeedDatabaseWorker.Companion.KEY_FILENAME

@Database(
    entities = [LotDetail::class, DrawLotHistory::class],
    views = [DrawLotHistoryView::class],
    version = 9,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun lotDetailDao(): LotDetailDao
    abstract fun drawLotHistoryDao(): DrawLotHistoryDao
    abstract fun drawLotHistoryViewDao(): DrawLotHistoryViewDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .addCallback(
                    object : RoomDatabase.Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            val request = OneTimeWorkRequestBuilder<SeedDatabaseWorker>()
                                .setInputData(workDataOf(KEY_FILENAME to LOT_DETAIL_DATA_FILENAME))
                                .build()
                            WorkManager.getInstance(context).enqueue(request)
                        }

                        override fun onDestructiveMigration(db: SupportSQLiteDatabase) {
                            super.onDestructiveMigration(db)
                            val request = OneTimeWorkRequestBuilder<SeedDatabaseWorker>()
                                .setInputData(workDataOf(KEY_FILENAME to LOT_DETAIL_DATA_FILENAME))
                                .build()
                            WorkManager.getInstance(context).enqueue(request)
                        }
                    }
                )
                .build()
        }
    }

}