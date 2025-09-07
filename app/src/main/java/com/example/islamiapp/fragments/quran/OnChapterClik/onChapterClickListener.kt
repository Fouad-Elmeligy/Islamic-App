package com.example.islamiapp.fragments.quran.OnChapterClik

import com.example.islamiapp.fragments.quran.DataModel.ChaptersDM

interface onChapterClickListener {
    fun onChapterClick(item: ChaptersDM,position:Int)
}