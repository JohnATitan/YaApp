package com.naat.yaapp.presentation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.naat.yaapp.R
import com.naat.yaapp.data.models.Recharge
import com.naat.yaapp.databinding.ActivityBuyRechargeBinding
import com.naat.yaapp.domain.presenters.BuyRechargePresenter
import com.naat.yaapp.domain.utils.Constant
import com.naat.yaapp.presentation.activities.views.BuyRechargeView
import com.naat.yaapp.presentation.dialogs.ConfirmRechargeDialog
import com.naat.yaapp.presentation.dialogs.DoneRechargeDialog
import com.squareup.picasso.Picasso

class BuyRechargeActivity : AppCompatActivity(), BuyRechargeView {

    private val binding: ActivityBuyRechargeBinding by lazy {
        ActivityBuyRechargeBinding.inflate(layoutInflater)
    }

    private lateinit var presenter: BuyRechargePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        window.statusBarColor = getColor(R.color.secondary_blue)

        val idRecharge = intent.getLongExtra(Constant.ID_RECHARGE, 0)
        initPresenter(idRecharge)
        initListener()
        initValues()
    }

    private fun initPresenter(idRecharge: Long) {
        presenter = BuyRechargePresenter(idRecharge, this)
    }

    private fun initListener() {
        binding.btnContinue.setOnClickListener {
//            ConfirmRechargeDialog(presenter.recharge).show(supportFragmentManager, "")
            DoneRechargeDialog().show(supportFragmentManager, "")
        }
    }

    private fun initValues() {
        presenter.getRecharge()
    }

    override fun showRecharge(recharge: Recharge) {
        with(binding){
            Picasso.get().load("file:///android_asset" + recharge.urlSecIcon).into(ivIcon)
            etPrice.setText(recharge.price.toString()).also {
                etPrice.isEnabled = false
            }
            tvService.text = "${if (recharge.serviceType == 1) Constant.TIME else Constant.MEGAS} - ${recharge.value}"
        }
    }


}