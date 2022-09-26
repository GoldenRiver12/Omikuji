package com.example.omikuji.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.omikuji.data.*
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LotsHistoryViewModel @Inject constructor(
    drawLotHistoryViewRepository: DrawLotHistoryViewRepository
) : ViewModel() {

    val drawLotHistories: LiveData<List<DrawLotHistoryView>> = drawLotHistoryViewRepository.getAllHistoryOrderByDrewOn().asLiveData()
}