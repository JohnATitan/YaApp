package com.naat.yaapp.presentation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.naat.yaapp.R

class BuyRechargeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buy_recharge)
        window.statusBarColor = getColor(R.color.secondary_blue)

    }
}