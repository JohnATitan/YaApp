package com.naat.yaapp.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.naat.yaapp.R
import com.naat.yaapp.data.models.Recharge
import com.naat.yaapp.databinding.AdapterRechargeBinding
import com.naat.yaapp.domain.utils.Constant
import com.naat.yaapp.presentation.adapters.listeners.RechargeListener

class RechargeAdapter(val recharges: Array<List<Recharge>>, val listener: RechargeListener) : RecyclerView.Adapter<RechargeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val root = LayoutInflater.from(parent.context).inflate(R.layout.adapter_recharge, parent, false)
        return ViewHolder(root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(recharges[position])
    }

    override fun getItemCount(): Int {
        return recharges.size
    }


    inner class ViewHolder(val itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = AdapterRechargeBinding.bind(itemView)

        fun bind(recharges: List<Recharge>) {
            binding.tvCompany.text = recharges[0].companyName.uppercase()

            binding.tvOne.text = if (recharges[0].serviceType == 1) Constant.TIME else Constant.MEGAS
            binding.tvTwo.text = if (recharges[1].serviceType == 1) Constant.TIME else Constant.MEGAS
            binding.tvThree.text = if (recharges[2].serviceType == 1) Constant.TIME else Constant.MEGAS

            binding.tvMore.setOnClickListener {
                listener.showRechargesDialog(recharges)
            }
        }
    }
}