package com.naat.yaapp.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.naat.yaapp.R
import com.naat.yaapp.data.models.Recharge
import com.naat.yaapp.databinding.AdapterRechargeItemBinding
import com.naat.yaapp.domain.utils.Constant
import com.naat.yaapp.presentation.adapters.listeners.RechargeListener

class RechargeItemAdapter(val recharges: List<Recharge>) : RecyclerView.Adapter<RechargeItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val root = LayoutInflater.from(parent.context).inflate(R.layout.adapter_recharge_item, parent, false)
        return ViewHolder(root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(recharges[position])
    }

    override fun getItemCount(): Int {
        return recharges.size
    }


    inner class ViewHolder(val itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = AdapterRechargeItemBinding.bind(itemView)

        fun bind(recharge: Recharge) {
            binding.tvOne.text = if (recharge.serviceType == 1) Constant.TIME else Constant.MEGAS
        }
    }
}