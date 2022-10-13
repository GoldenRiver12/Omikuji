package com.example.omikuji.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.omikuji.data.DrawLotHistoryView
import com.example.omikuji.databinding.DrawLotHistoryItemBinding

private object DiffCallback: DiffUtil.ItemCallback<DrawLotHistoryView>(){
    override fun areItemsTheSame(
        oldItem: DrawLotHistoryView,
        newItem: DrawLotHistoryView
    ): Boolean {
        return oldItem.drawLotHistoryId == newItem.drawLotHistoryId
    }

    override fun areContentsTheSame(
        oldItem: DrawLotHistoryView,
        newItem: DrawLotHistoryView
    ): Boolean {
        return oldItem == newItem
    }

}

class DrawLotHistoryAdapter : ListAdapter<DrawLotHistoryView, DrawLotHistoryAdapter.DrawLotHistoryViewHolder>(DiffCallback){

    class DrawLotHistoryViewHolder(private val binding: DrawLotHistoryItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(history: DrawLotHistoryView){
            binding.apply {
                drawLotHistoryView = history
                executePendingBindings()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrawLotHistoryViewHolder {
        return DrawLotHistoryViewHolder(
            DrawLotHistoryItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: DrawLotHistoryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}