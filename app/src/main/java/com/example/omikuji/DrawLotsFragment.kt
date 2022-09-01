package com.example.omikuji

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.omikuji.databinding.FragmentDrawLotsBinding
import com.example.omikuji.databinding.FragmentLotsHistoryBinding
import com.example.omikuji.viewmodels.DrawLotsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DrawLotsFragment : Fragment() {

    private lateinit var binding: FragmentDrawLotsBinding

    private val viewModel: DrawLotsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentDrawLotsBinding.inflate(inflater, container, false)

        binding.btnFragmentLotsHistory.setOnClickListener { v ->
            Navigation.findNavController(v).navigate(R.id.lotsHistoryFragment)
        }

        binding.btnDrawLot.setOnClickListener {
            binding.lotDetail.text = drawLot()
        }

        return binding.root
    }

    private fun drawLot(): String {
        return viewModel.lotDetails.random()
    }
}