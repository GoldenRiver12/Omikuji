package com.example.omikuji.viewmodels

import androidx.lifecycle.*
import com.example.omikuji.data.DrawLotHistory
import com.example.omikuji.data.DrawLotHistoryRepository
import com.example.omikuji.data.LotDetail
import com.example.omikuji.data.LotDetailRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapNotNull
import kotlinx.coroutines.launch
import java.time.ZonedDateTime
import javax.inject.Inject

@HiltViewModel
class DrawLotsViewModel @Inject constructor(
    val lotDetailRepository: LotDetailRepository,
    val drawLotHistoryRepository: DrawLotHistoryRepository
) : ViewModel() {

    var drawnLot: MutableLiveData<LotDetail> = MutableLiveData()

    fun drawLot() {
        viewModelScope.launch(Dispatchers.IO) {
            val lotDetails = lotDetailRepository.getLotDetails()
            val drawnLotTmp = lotDetails.random()
            drawnLot.postValue(drawnLotTmp)
            val drawLotHistory =
                DrawLotHistory(lotId = drawnLotTmp.id, drewOn = ZonedDateTime.now())
            drawLotHistoryRepository.saveDrawLotHistory(drawLotHistory)
        }
    }

}