package com.example.omikuji.data.viewModels

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.example.omikuji.data.AppDatabase
import com.example.omikuji.data.DrawLotHistoryRepository
import com.example.omikuji.data.LotDetailDao
import com.example.omikuji.data.LotDetailRepository
import com.example.omikuji.utilities.testLotDetails
import com.example.omikuji.viewmodels.DrawLotsViewModel
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.assertj.core.api.Assertions.*
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.rules.RuleChain
import javax.inject.Inject

@HiltAndroidTest
class DrawLotsViewModelTest {


    private val hiltRule = HiltAndroidRule(this)

    @get:Rule
    val rule = RuleChain
        .outerRule(hiltRule)

    private lateinit var appDatabase: AppDatabase
    private lateinit var viewModel: DrawLotsViewModel
    private lateinit var lotDetailDao: LotDetailDao

    @Inject
    lateinit var lotDetailRepository: LotDetailRepository

    @Inject
    lateinit var drawLotHistoryRepository: DrawLotHistoryRepository

    @Before
    fun setUp() {
        hiltRule.inject()

        val context = InstrumentationRegistry.getInstrumentation().targetContext
        appDatabase = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
        lotDetailDao = appDatabase.lotDetailDao()
        runBlocking {
            lotDetailDao.insertAll(testLotDetails)
        }
        viewModel = DrawLotsViewModel(lotDetailRepository, drawLotHistoryRepository)
    }

    @After
    fun tearDown() {
        appDatabase.close()
    }

    @Test
    fun testNull() {
        assertThat(4)
            .isEqualTo(2 + 2)
    }

    @Test
    fun testDrawLot(){
        viewModel.drawLot()
        assertThat(viewModel.drawnLot.value)
            .isNotNull
    }

}