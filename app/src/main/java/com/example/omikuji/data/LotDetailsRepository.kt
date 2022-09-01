package com.example.omikuji.data

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LotDetailsRepository @Inject constructor() {

    //TODO DBから取得するよう置き換える
    fun getLotDetails(): List<String> {
        return listOf("大吉", "中吉", "小吉", "凶")
    }

}