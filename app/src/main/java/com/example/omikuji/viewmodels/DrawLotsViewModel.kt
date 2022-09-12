package com.example.omikuji.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.omikuji.data.LotDetail
import com.example.omikuji.data.LotDetailRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DrawLotsViewModel @Inject constructor(
    lotDetailRepository: LotDetailRepository
) : ViewModel() {

    val lotDetails: LiveData<List<LotDetail>> = lotDetailRepository.getLotDetails().asLiveData()

    fun drawLot(): LotDetail {
        return lotDetails.value?.random()!!
    }

}