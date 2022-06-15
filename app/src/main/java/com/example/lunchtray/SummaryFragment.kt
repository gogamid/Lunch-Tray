package com.example.lunchtray

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.lunchtray.databinding.FragmentSideDishBinding
import com.example.lunchtray.databinding.FragmentSummaryBinding


class SummaryFragment : Fragment() {

  private lateinit var binding: FragmentSummaryBinding
  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    // Inflate the layout for this fragment
    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_summary, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding.summaryFragment = this
  }

  fun submitOrder() {
    this.findNavController().navigate(R.id.action_summaryFragment_to_startOrderFragment)
  }

  fun cancelOrder() {
    this.findNavController().navigate(R.id.action_summaryFragment_to_startOrderFragment)
  }
}