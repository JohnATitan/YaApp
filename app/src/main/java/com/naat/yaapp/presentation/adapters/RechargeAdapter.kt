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
import com.naat.yaapp.presentation.adapters.listeners.RechargeSelectedListener
import com.squareup.picasso.Picasso

class RechargeAdapter(val listener: RechargeListener, val onSelectedListener: RechargeSelectedListener) : RecyclerView.Adapter<RechargeAdapter.ViewHolder>() {

    var auxRecharges: Array<List<Recharge>>? = null
    var recharges: Array<List<Recharge>>? = null
        set(value) {
            field = value
            auxRecharges = value
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val root = LayoutInflater.from(parent.context).inflate(R.layout.adapter_recharge, parent, false)
        return ViewHolder(root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(auxRecharges!![position])
    }

    override fun getItemCount(): Int {
        return auxRecharges?.size ?: 0
    }

    fun filterCompany(companyName: String) {
        val list = mutableListOf<List<Recharge>>()

        if (companyName.isEmpty()) {
            listener.showFailFilterMessage("Se requieren un parametro de busqueda")
            list.addAll(recharges!!.asList())
        } else {
            recharges!!.forEach {
                if (companyName.lowercase().equals(it[0].companyName.lowercase())) {
                    list.add(it)
                    return@forEach
                }
            }

            if (list.isEmpty()) {
                list.addAll(recharges!!.asList())
                listener.showFailFilterMessage("No se encontro ninguna compañia")
            }
        }

        auxRecharges = list.toTypedArray()
        notifyDataSetChanged()
    }


    inner class ViewHolder(val itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = AdapterRechargeBinding.bind(itemView)

        fun bind(recharges: List<Recharge>) {
            binding.tvCompany.text = recharges[0]?.companyName.uppercase()

            with(binding) {
                recharges[0]?.let {
                    tvOne.text = if (it.serviceType == 1) Constant.TIME else Constant.MEGAS
                    tvOneValue.text = it.value
                    Picasso.get().load("file:///android_asset" + it.urlMainIcon).resize(200, 200).centerCrop().into(ivOne)

                    ivOne.setOnClickListener { _ ->
                        onSelectedListener.onSelectedRecharge(it.idRecharge)
                    }
                }

                recharges[1]?.let {
                    tvTwo.text = if (it.serviceType == 1) Constant.TIME else Constant.MEGAS
                    tvTwoValue.text = it.value
                    Picasso.get().load("file:///android_asset" + it.urlMainIcon).resize(200, 200).centerCrop().into(ivTwo)

                    ivTwo.setOnClickListener { _ ->
                        onSelectedListener.onSelectedRecharge(it.idRecharge)
                    }
                }

                recharges[2]?.let {
                    tvThree.text = if (it.serviceType == 1) Constant.TIME else Constant.MEGAS
                    tvThreeValue.text = it.value
                    Picasso.get().load("file:///android_asset" + it.urlMainIcon).resize(200, 200).centerCrop().into(ivThree)

                    ivThree.setOnClickListener { _ ->
                        onSelectedListener.onSelectedRecharge(it.idRecharge)
                    }
                }
            }

            binding.tvMore.setOnClickListener {
                listener.showRechargesDialog(recharges)
            }
        }
    }
}