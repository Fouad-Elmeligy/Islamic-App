package com.example.islamiapp.Activitys.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islamiapp.databinding.ItemVerseBinding

class VersesAdapter (private val Verses: List<String>): RecyclerView.Adapter<VersesAdapter.VerseViewHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): VerseViewHolder {
        val binding= ItemVerseBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return VerseViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: VerseViewHolder,
        position: Int
    ) {
        var verse=Verses[position]
        holder.bind(verse,position)
    }

    override fun getItemCount(): Int {
        return Verses.size
    }

    class VerseViewHolder(val binding: ItemVerseBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(item:String,position:Int){
            binding.verseText.text=" [$position]  $item "
        }
    }
}