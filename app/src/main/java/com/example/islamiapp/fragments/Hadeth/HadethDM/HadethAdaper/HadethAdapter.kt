package com.example.islamiapp.fragments.Hadeth.HadethDM.HadethAdaper

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islamiapp.databinding.ItemHadethBinding
import com.example.islamiapp.fragments.Hadeth.HadethDM.HadethDM
import com.example.islamiapp.fragments.Hadeth.OnItemHadthClick.OnItemHadethClick

class HadethAdapter (private var ahadeth: ArrayList<HadethDM>): RecyclerView.Adapter<HadethAdapter.HadethViewHolder>(){
    private lateinit var binding: ItemHadethBinding
    lateinit var onItemHadethClick: OnItemHadethClick
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HadethViewHolder {
        binding= ItemHadethBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return HadethViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: HadethViewHolder,
        position: Int
    ) {
        var hadeth=ahadeth[position]
        holder.bind(hadeth,onItemHadethClick)
    }

    override fun getItemCount(): Int {
        return ahadeth.size
    }

    class HadethViewHolder(val binding: ItemHadethBinding): RecyclerView.ViewHolder(binding.root){
        fun bind( item:HadethDM,onItemHadethClick: OnItemHadethClick){
            binding.hadethTitle.text=item.title
            binding.hadethContent.text=item.content
            binding.root.setOnClickListener {
               onItemHadethClick.onItemHadethClick(item)

            }
        }
    }
}