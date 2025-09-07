package com.example.islamiapp.fragments.quran.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islamiapp.databinding.ItemQuranChapterBinding
import com.example.islamiapp.fragments.quran.DataModel.ChaptersDM
import com.example.islamiapp.fragments.quran.OnChapterClik.onChapterClickListener

class ChaptersAdapter(private val chapters: List<ChaptersDM>) :
    RecyclerView.Adapter<ChaptersAdapter.ChapterViewHolder>() {
    private lateinit var binding: ItemQuranChapterBinding
    lateinit var onChapterClickListener: onChapterClickListener
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ChapterViewHolder {
        binding =
            ItemQuranChapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ChapterViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ChapterViewHolder,
        position: Int
    ) {
        var item = chapters[position]
        holder.bind(item,position,onChapterClickListener)
    }

    override fun getItemCount(): Int {
        return chapters.size
    }

    class ChapterViewHolder(val binding: ItemQuranChapterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ChaptersDM, position: Int,onChapterClickListener: onChapterClickListener) {
            binding.chapterIndexView.text = item.index.toString()
            binding.chapterLengthTextView.text = "${item.length} Verses"
            binding.chapterNameInArabic.text = item.nameInArabic
            binding.chapterNameInEnglish.text = item.nameInEnglish
            binding.root.setOnClickListener {
                onChapterClickListener.onChapterClick(item,position)
            }
        }
    }
}