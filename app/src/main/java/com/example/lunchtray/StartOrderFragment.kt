package com.example.lunchtray

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.lunchtray.databinding.FragmentStartOrderBinding
import com.example.lunchtray.model.OrderViewModel

class StartOrderFragment : Fragment() {
  private val sharedViewModel: OrderViewModel by activityViewModels()
  private lateinit var binding: FragmentStartOrderBinding
  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_start_order, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding.startOrderFragment = this
  }

  fun nextScreen() {
    sharedViewModel.resetOrder()
    sharedViewModel.setFirstEntree()
    this.findNavController().navigate(R.id.action_startOrderFragment_to_entreeFragment)
  }
}