package com.example.omikuji

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.omikuji.databinding.FragmentDrawLotsBinding
import com.example.omikuji.viewmodels.DrawLotsViewModel
import com.example.omikuji.viewmodels.LotsHistoryViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LotsHistoryFragment : Fragment() {

    private lateinit var binding: LotsHistoryFragment

    private val viewModel: LotsHistoryViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lots_history, container, false)
    }
}