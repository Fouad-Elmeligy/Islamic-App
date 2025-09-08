package com.example.islamiapp.fragments.quran

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islamiapp.fragments.quran.QuranVersesActivity
import com.example.islamiapp.databinding.FragmentQuranBinding
import com.example.islamiapp.fragments.quran.DataModel.ChaptersDM
import com.example.islamiapp.fragments.quran.OnChapterClik.onChapterClickListener
import com.example.islamiapp.fragments.quran.Utils.QuranUtils
import com.example.islamiapp.fragments.quran.adapter.ChaptersAdapter

class QuranFragment: Fragment() {
    private lateinit var binding: FragmentQuranBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentQuranBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter= ChaptersAdapter(QuranUtils.getChapters())
        binding.quranRecyclerView.adapter=adapter
        adapter.onChapterClickListener=object : onChapterClickListener{
            override fun onChapterClick(
                item: ChaptersDM,
                position: Int
            ) {
                val intent=Intent(context, QuranVersesActivity::class.java)
                intent.putExtra("chapterIndex",item.index.toString())
                intent.putExtra("chapterNameInArabic",item.nameInArabic)
                intent.putExtra("chapterNameInEnglish",item.nameInEnglish)
                startActivity(intent)

            }

        }
    }
}