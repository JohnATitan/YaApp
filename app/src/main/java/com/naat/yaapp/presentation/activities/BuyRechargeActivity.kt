package com.naat.yaapp.presentation.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.naat.yaapp.R
import com.naat.yaapp.data.models.Recharge
import com.naat.yaapp.databinding.ActivityBuyRechargeBinding
import com.naat.yaapp.domain.presenters.BuyRechargePresenter
import com.naat.yaapp.domain.utils.Constant
import com.naat.yaapp.presentation.activities.views.BuyRechargeView
import com.naat.yaapp.presentation.dialogs.ConfirmRechargeDialog
import com.naat.yaapp.presentation.dialogs.DoneRechargeDialog
import com.naat.yaapp.presentation.dialogs.listeners.ConfirmRechargeListener
import com.naat.yaapp.presentation.dialogs.listeners.DoneRechargeListener
import com.squareup.picasso.Picasso

class BuyRechargeActivity : AppCompatActivity(), BuyRechargeView, ConfirmRechargeListener, DoneRechargeListener {

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
            presenter.validNumber(binding.etPhone.text.toString())
        }

        binding.ivBack.setOnClickListener {
            backToDashboard()
        }
    }

    private fun initValues() {
        presenter.getRecharge()
    }

    override fun showRecharge(recharge: Recharge) {
        with(binding) {
            Picasso.get().load("file:///android_asset" + recharge.urlSecIcon).into(ivIcon)
            etPrice.setText(recharge.price.toString()).also {
                etPrice.isEnabled = false
            }
            tvService.text = "${if (recharge.serviceType == 1) Constant.TIME else Constant.MEGAS} - ${recharge.value}"
        }
    }

    override fun showErrorNumber() {
        Toast.makeText(this, "Ingresa un número correcto", Toast.LENGTH_SHORT).show()
    }

    override fun showConfirmDialog() {
        ConfirmRechargeDialog(presenter.recharge, binding.etPhone.text.toString(), this).show(supportFragmentManager, "")
    }

    override fun onConfirmRecharge() {
        DoneRechargeDialog(this).show(supportFragmentManager, "")
    }

    override fun onfinishRecharge() {
        backToDashboard()
    }

    override fun onBackPressed() {
        backToDashboard()
    }

    private fun backToDashboard() {
        val dashboard = Intent(this, DashboardActivity::class.java)
        startActivity(dashboard)
        finish()
    }
}