package com.naat.yaapp.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.naat.yaapp.data.models.Recharge
import com.naat.yaapp.databinding.FragmentRechargeBinding
import com.naat.yaapp.domain.presenters.fragments.RechargePresenter
import com.naat.yaapp.presentation.adapters.RechargeAdapter
import com.naat.yaapp.presentation.fragments.views.RechargeView

class RechargeFragment : Fragment(), RechargeView{

    private var _binding: FragmentRechargeBinding? = null
    private val binding get() = _binding!!

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

    private fun initPresenter(){
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
        rvRecharges.adapter = RechargeAdapter(recharges)
    }
}