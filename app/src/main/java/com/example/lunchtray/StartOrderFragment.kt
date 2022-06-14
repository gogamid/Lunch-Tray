package com.example.lunchtray

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.lunchtray.databinding.FragmentStartOrderBinding

class StartOrderFragment : Fragment() {
  private lateinit var binding: FragmentStartOrderBinding
  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentStartOrderBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding.startOrderButton.setOnClickListener {
      this.findNavController().navigate(R.id.action_startOrderFragment_to_entreeFragment)
    }
  }
}