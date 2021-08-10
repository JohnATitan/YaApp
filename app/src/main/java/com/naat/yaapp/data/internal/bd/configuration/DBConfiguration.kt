package com.naat.yaapp.data.internal.bd.configuration

import androidx.room.Database
import androidx.room.RoomDatabase
import com.naat.yaapp.data.models.Recharge

@Database(entities = arrayOf(Recharge::class), version = 1, exportSchema = false)
abstract class DBConfiguration : RoomDatabase() {
    abstract fun getDAO(): DAO
}