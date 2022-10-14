package com.example.omikuji

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.omikuji.adapters.DrawLotHistoryAdapter
import com.example.omikuji.data.DrawLotHistoryView
import com.example.omikuji.databinding.FragmentLotsHistoryBinding
import com.example.omikuji.viewmodels.LotsHistoryViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.time.ZonedDateTime

@AndroidEntryPoint
class LotsHistoryFragment : Fragment() {

    private lateinit var binding: FragmentLotsHistoryBinding
    private lateinit var drawLotHistoryAdapter: DrawLotHistoryAdapter

    private val viewModel: LotsHistoryViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLotsHistoryBinding.inflate(inflater, container, false)
        initDrawLotHistoryRecyclerView()
        binding.btnDrawLots.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.drawLotsFragment)
        }
        return binding.root
    }

    fun initDrawLotHistoryRecyclerView(){
        drawLotHistoryAdapter = DrawLotHistoryAdapter()
        binding.drawLotHistoryRecyclerView.apply{
            adapter = drawLotHistoryAdapter
            layoutManager = LinearLayoutManager(activity)
        }
        viewModel.drawLotHistories.observe(viewLifecycleOwner){
            drawLotHistoryAdapter.submitList(it)
        }
    }
}