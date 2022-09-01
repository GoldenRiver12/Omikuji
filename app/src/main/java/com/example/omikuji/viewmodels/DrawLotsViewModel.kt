package com.example.omikuji.viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.omikuji.data.LotDetailsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DrawLotsViewModel @Inject constructor(
    lotDetailsRepository: LotDetailsRepository
): ViewModel() {

    val lotDetails = lotDetailsRepository.getLotDetails()

}