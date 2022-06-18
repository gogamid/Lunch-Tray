package com.example.lunchtray

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.lunchtray.databinding.FragmentSummaryBinding
import com.example.lunchtray.model.OrderViewModel


class SummaryFragment : Fragment() {
  private val sharedViewModel: OrderViewModel by activityViewModels()
  private lateinit var binding: FragmentSummaryBinding
  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_summary, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding.apply {
      summaryFragment = this@SummaryFragment
      viewModel = sharedViewModel
      lifecycleOwner = viewLifecycleOwner
    }
  }

  fun submitOrder() {
    Toast.makeText(requireContext(), "Order Submitted", Toast.LENGTH_SHORT).show()
    sharedViewModel.resetOrder()
    this.findNavController().navigate(R.id.action_summaryFragment_to_startOrderFragment)
  }

  fun cancelOrder() {
    sharedViewModel.resetOrder()
    this.findNavController().navigate(R.id.action_summaryFragment_to_startOrderFragment)
  }
}