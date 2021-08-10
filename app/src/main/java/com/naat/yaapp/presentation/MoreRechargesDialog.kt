package com.naat.yaapp.presentation

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
import com.naat.yaapp.databinding.DialogMoreRechargesBinding
import com.naat.yaapp.presentation.adapters.RechargeItemAdapter
import android.util.DisplayMetrics




class MoreRechargesDialog(val recharges: List<Recharge>) : DialogFragment() {

    private var _binding: DialogMoreRechargesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));

        _binding = DialogMoreRechargesBinding.inflate(inflater, container, false)
        val root = binding.root

        binding.rv.layoutManager = GridLayoutManager(context, 3, GridLayoutManager.VERTICAL, false)
        binding.rv.adapter = RechargeItemAdapter(recharges)

        return root
    }

    override fun onResume() {
        super.onResume()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, (Resources.getSystem().getDisplayMetrics().heightPixels * 0.6).toInt())
    }

}