package com.example.lunchtray

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.lunchtray.databinding.FragmentSideDishBinding
import com.example.lunchtray.model.OrderViewModel


class SideDishFragment : Fragment() {
  private val sharedViewModel: OrderViewModel by activityViewModels()
  private lateinit var binding: FragmentSideDishBinding
  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_side_dish, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding.apply {
      sideDishFragment = this@SideDishFragment
      viewModel = sharedViewModel
      lifecycleOwner = viewLifecycleOwner
    }
  }

  fun nextScreen() {
    this.findNavController().navigate(R.id.action_sideDishFragment_to_accompanimentFragment)
  }

  fun cancelOrder() {
    sharedViewModel.resetOrder()
    this.findNavController().navigate(R.id.action_sideDishFragment_to_startOrderFragment)
  }

}