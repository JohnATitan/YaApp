package com.naat.yaapp.data.internal.bd.configuration

import androidx.room.Room
import com.naat.yaapp.App

object DBInstance {
    val db: DBConfiguration by lazy {
        Room.databaseBuilder(App.context, DBConfiguration::class.java, "YaDB").allowMainThreadQueries().build()
    }
}