package com.naat.yaapp.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.naat.yaapp.R

class EmptyFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_empty, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(): EmptyFragment {
            return EmptyFragment()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}