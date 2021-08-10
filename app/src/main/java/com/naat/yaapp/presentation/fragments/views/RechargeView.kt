package com.naat.yaapp.presentation.fragments.views

import com.naat.yaapp.data.models.Recharge

interface RechargeView {
    fun showRecharges(recharges: Array<List<Recharge>>)
}