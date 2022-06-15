package com.example.lunchtray

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.lunchtray.databinding.FragmentEntreeBinding

class EntreeFragment : Fragment() {
  private lateinit var binding: FragmentEntreeBinding

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    // Inflate the layout for this fragment
    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_entree, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding.entreeFragment = this
  }

  fun nextScreen() {
    this.findNavController().navigate(R.id.action_entreeFragment_to_sideDishFragment)
  }

  fun cancelOrder() {
    this.findNavController().navigate(R.id.action_entreeFragment_to_startOrderFragment)
  }

}