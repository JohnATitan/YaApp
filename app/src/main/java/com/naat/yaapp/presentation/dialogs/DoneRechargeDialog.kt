package com.naat.yaapp.presentation.dialogs

import android.content.res.Resources
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.naat.yaapp.databinding.DialogDoneRechargeBinding
import com.naat.yaapp.presentation.dialogs.listeners.DoneRechargeListener

class DoneRechargeDialog(val listener: DoneRechargeListener) : DialogFragment() {

    private var _binding: DialogDoneRechargeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));
        isCancelable = false
        _binding = DialogDoneRechargeBinding.inflate(inflater, container, false)
        val root = binding.root
        initListeners()
        return root
    }

    private fun initListeners() {
        binding.btnAccept.setOnClickListener {
            dismiss()
            listener.onfinishRecharge()
        }
    }

    override fun onResume() {
        super.onResume()
        dialog?.window?.setLayout((Resources.getSystem().getDisplayMetrics().widthPixels * 0.9).toInt(), ViewGroup.LayoutParams.WRAP_CONTENT)
    }

}