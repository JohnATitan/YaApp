package com.naat.yaapp.presentation.adapters.listeners

import com.naat.yaapp.data.models.Recharge

interface RechargeListener {
    fun showRechargesDialog(recharges: List<Recharge>)
    fun showFailFilterMessage(message: String)
}