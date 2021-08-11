package com.naat.yaapp.presentation.dialogs

import android.content.res.Resources
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.GridLayoutManager
import com.naat.yaapp.data.models.Recharge
import com.naat.yaapp.databinding.DialogCoonfirmRechargeBinding
import com.naat.yaapp.databinding.DialogMoreRechargesBinding
import com.naat.yaapp.domain.utils.Constant
import com.naat.yaapp.presentation.adapters.RechargeItemAdapter
import com.naat.yaapp.presentation.adapters.listeners.RechargeSelectedListener
import com.squareup.picasso.Picasso
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.*

class ConfirmRechargeDialog(val recharge: Recharge) : DialogFragment() {

    private var _binding: DialogCoonfirmRechargeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));

        _binding = DialogCoonfirmRechargeBinding.inflate(inflater, container, false)
        val root = binding.root

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
        }

        return root
    }

    override fun onResume() {
        super.onResume()
        dialog?.window?.setLayout((Resources.getSystem().getDisplayMetrics().widthPixels * 0.9).toInt(), ViewGroup.LayoutParams.WRAP_CONTENT)
    }

}