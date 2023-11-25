package com.example.lab11

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lab11.databinding.ItemRecyclerviewBinding

class MyViewHolder(val binding: ItemRecyclerviewBinding) :
    RecyclerView.ViewHolder(binding.root)

class MyAdapter(val datas: MutableList<String>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>()

{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder
        = MyViewHolder(ItemRecyclerviewBinding.inflate(LayoutInflater.from()))


    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as MyViewHolder).binding
        binding.itemImage.setImageResource(android.R.drawable.star_on)
        binding.itemData.text = datas[position]
    }
}