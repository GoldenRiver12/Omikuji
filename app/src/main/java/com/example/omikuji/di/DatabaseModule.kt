package com.example.omikuji.di

import android.content.Context
import com.example.omikuji.data.AppDatabase
import com.example.omikuji.data.DrawLotHistoryDao
import com.example.omikuji.data.LotDetailDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context):AppDatabase{
        return AppDatabase.getInstance(context)
    }

    @Provides
    fun provideLotDetailsDao(appDatabase: AppDatabase):LotDetailDao{
        return appDatabase.lotDetailDao()
    }

    @Provides
    fun provideDrawLotHistoryDao(appDatabase: AppDatabase): DrawLotHistoryDao{
        return appDatabase.drawLotHistoryDao()
    }

}