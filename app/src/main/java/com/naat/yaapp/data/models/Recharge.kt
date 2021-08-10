package com.naat.yaapp.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Recharge(
    @PrimaryKey(autoGenerate = true)
    val idRecharge: Long,
    val companyName: String,
    val serviceType: Int,
    val value: String,
    val price: Double,
    val urlMainIcon: String,
    val urlSecIcon: String
)
// 1 Tiempo aire
// 2 megas