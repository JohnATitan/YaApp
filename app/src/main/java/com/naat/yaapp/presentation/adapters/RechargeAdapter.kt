package com.naat.yaapp.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.naat.yaapp.R

class RechargeAdapter : RecyclerView.Adapter<RechargeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val root = LayoutInflater.from(parent.context).inflate(R.layout.adapter_recharge, parent, false)
        return ViewHolder(root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return 6
    }


    class ViewHolder(val itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}