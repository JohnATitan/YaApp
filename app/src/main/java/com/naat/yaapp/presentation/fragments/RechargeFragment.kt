package com.naat.yaapp.presentation.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.naat.yaapp.data.models.Recharge
import com.naat.yaapp.databinding.FragmentRechargeBinding
import com.naat.yaapp.domain.presenters.fragments.RechargePresenter
import com.naat.yaapp.domain.utils.Constant
import com.naat.yaapp.presentation.activities.BuyRechargeActivity
import com.naat.yaapp.presentation.dialogs.MoreRechargesDialog
import com.naat.yaapp.presentation.adapters.RechargeAdapter
import com.naat.yaapp.presentation.adapters.listeners.RechargeListener
import com.naat.yaapp.presentation.adapters.listeners.RechargeSelectedListener
import com.naat.yaapp.presentation.fragments.views.RechargeView

class RechargeFragment : Fragment(), RechargeView, RechargeListener, RechargeSelectedListener {

    private var _binding: FragmentRechargeBinding? = null
    private val binding get() = _binding!!

    private var moreRechargesDialog: MoreRechargesDialog? = null

    private lateinit var presenter: RechargePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initPresenter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentRechargeBinding.inflate(inflater, container, false)
        val root = binding.root

        binding.rvRecharges.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        presenter.getRecharges()

        return root
    }

    private fun initPresenter() {
        presenter = RechargePresenter(this)
    }

    companion object {
        @JvmStatic
        fun newInstance(): RechargeFragment {
            return RechargeFragment()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun showRecharges(recharges: Array<List<Recharge>>) {
        val rvRecharges = binding.rvRecharges
        rvRecharges.adapter = RechargeAdapter(recharges, this, this)
    }

    override fun showRechargesDialog(recharges: List<Recharge>) {
        moreRechargesDialog = MoreRechargesDialog(recharges, this)
        moreRechargesDialog!!.show(childFragmentManager, "")
    }

    override fun onSelectedRecharge(idRecharge: Long) {
        moreRechargesDialog?.let {
            it.dismiss()
        }
        val buy = Intent(context, BuyRechargeActivity::class.java)
        buy.putExtra(Constant.ID_RECHARGE, idRecharge)
        startActivity(buy)
        requireActivity().finish()
    }
}