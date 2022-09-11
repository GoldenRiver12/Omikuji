package com.example.omikuji.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.omikuji.data.LotDetails
import com.example.omikuji.data.LotDetailsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DrawLotsViewModel @Inject constructor(
    lotDetailsRepository: LotDetailsRepository
) : ViewModel() {

    val lotDetails: LiveData<List<LotDetails>> = lotDetailsRepository.getLotDetails().asLiveData()

    fun drawLot(): LotDetails {
        return lotDetails.value?.random()!!
    }

}