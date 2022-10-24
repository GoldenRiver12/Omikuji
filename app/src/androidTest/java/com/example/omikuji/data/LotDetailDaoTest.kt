package com.example.omikuji.data

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.omikuji.utilities.testLotDetails
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.assertj.core.api.Assertions.*


@RunWith(AndroidJUnit4::class)
class LotDetailDaoTest {

    private lateinit var lotDetailDao: LotDetailDao
    private lateinit var db: AppDatabase

    @Before
    fun createDb() = runBlocking{
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
        lotDetailDao = db.lotDetailDao()
        lotDetailDao.insertAll(testLotDetails)
    }

    @After
    @Throws(Exception::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun testGetLotDetails(){
        val lotDetails = lotDetailDao.getLotDetails()
        assertThat(lotDetails)
            .hasSize(3)
            .hasSameElementsAs(testLotDetails)
    }


}