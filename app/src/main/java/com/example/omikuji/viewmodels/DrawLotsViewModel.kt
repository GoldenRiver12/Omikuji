package com.example.omikuji.viewmodels

import androidx.lifecycle.*
import com.example.omikuji.data.LotDetail
import com.example.omikuji.data.LotDetailRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapNotNull
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DrawLotsViewModel @Inject constructor(
    val lotDetailRepository: LotDetailRepository
) : ViewModel() {

    var drawnLot: MutableLiveData<LotDetail> = MutableLiveData()

    fun drawLot(){
        viewModelScope.launch(Dispatchers.IO) {
            val lotDetails = lotDetailRepository.getLotDetails()
            drawnLot.postValue(lotDetails.random())
        }
    }

}