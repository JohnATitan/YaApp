package com.naat.yaapp.presentation.dialogs

import android.content.res.Resources
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.naat.yaapp.data.models.Recharge
import com.naat.yaapp.databinding.DialogConfirmRechargeBinding
import com.naat.yaapp.domain.utils.Constant
import com.naat.yaapp.presentation.dialogs.listeners.ConfirmRechargeListener
import com.squareup.picasso.Picasso
import java.text.SimpleDateFormat
import java.util.*

class ConfirmRechargeDialog(val recharge: Recharge, val number: String, val listener: ConfirmRechargeListener) : DialogFragment() {

    private var _binding: DialogConfirmRechargeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));

        _binding = DialogConfirmRechargeBinding.inflate(inflater, container, false)
        val root = binding.root
        initValues()
        initListeners()
        return root
    }

    private fun initValues() {
        var pattern = "HH:mm:ss"
        var simpleDateFormat = SimpleDateFormat(pattern)
        val date: String = simpleDateFormat.format(Date())

        pattern = "dd/MMM/yy"
        simpleDateFormat = SimpleDateFormat(pattern)
        val date2: String = simpleDateFormat.format(Date())

        with(binding) {
            Picasso.get().load("file:///android_asset" + recharge.urlSecIcon).into(ivIcon)
            tvService.text = "${if (recharge.serviceType == 1) Constant.TIME else Constant.MEGAS} - ${recharge.value}"
            tvValue.text = "$${recharge.price}"
            tvHour.text = date
            tvDate.text = date2.replace(".", "")
            tvNumber.text = number
        }
    }

    private fun initListeners() {
        binding.btnCancel.setOnClickListener {
            dismiss()
        }
        binding.btnAccept.setOnClickListener {
            dismiss()
            listener.onConfirmRecharge()
        }
    }

    override fun onResume() {
        super.onResume()
        dialog?.window?.setLayout((Resources.getSystem().getDisplayMetrics().widthPixels * 0.9).toInt(), ViewGroup.LayoutParams.WRAP_CONTENT)
    }

}