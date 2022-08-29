package com.example.omikuji

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.omikuji.databinding.FragmentDrawLotsBinding
import com.example.omikuji.databinding.FragmentLotsHistoryBinding

class DrawLotsFragment : Fragment() {

    private lateinit var binding: FragmentDrawLotsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentDrawLotsBinding.inflate(inflater, container, false)

        binding.btnFragmentLotsHistory.setOnClickListener { v ->
            Navigation.findNavController(v).navigate(R.id.lotsHistoryFragment)
        }

        return binding.root
    }


}