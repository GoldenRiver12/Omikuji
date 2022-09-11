package com.example.omikuji.workers

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker

import androidx.work.WorkerParameters
import com.example.omikuji.data.AppDatabase
import com.example.omikuji.data.LotDetails
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SeedDatabaseWorker(
    context: Context,
    workerParams: WorkerParameters
) : CoroutineWorker(context, workerParams) {
    override suspend fun doWork(): Result = withContext(Dispatchers.IO) {
        try {
            val filename = inputData.getString(KEY_FILENAME)
            if (filename != null) {
                applicationContext.assets.open(filename).use { inputStream ->
                    JsonReader(inputStream.reader()).use { jsonReader ->
                        val lotDetailsType = object : TypeToken<List<LotDetails>>() {}.type
                        val lotDetailList: List<LotDetails> =
                            Gson().fromJson(jsonReader, lotDetailsType)

                        val database = AppDatabase.getInstance(applicationContext)
                        database.lotDetailsDao().insertAll(lotDetailList)

                        Result.success()
                    }
                }
            } else {
                Log.e(TAG, "Error seeding database - no valid filename")
                Result.failure()
            }
        } catch (ex: Exception) {
            Log.e(TAG, "Error seeding database", ex)
            Result.failure()
        }
    }

    companion object {
        private const val TAG = "SeedDatabaseWorker"
        const val KEY_FILENAME = "LOT_DETAIL_DATA_FILENAME"
    }
}
