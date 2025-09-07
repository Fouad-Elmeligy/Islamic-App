package com.example.islamiapp.Activitys
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.islamiapp.Activitys.Adapters.VersesAdapter
import com.example.islamiapp.databinding.ActivityQuranVersesBinding

class QuranVersesActivity : AppCompatActivity() {
    private var chapterIndex: String?=null
    private var binding: ActivityQuranVersesBinding?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityQuranVersesBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        getVerseInfo()
        initRycycler()
        readFiles()
        binding?.backButton?.setOnClickListener{
            finish()
        }
        }

    private fun getVerseInfo() {
        chapterIndex=intent.getStringExtra("chapterIndex")
        binding?.chapterNameInEnglish?.text=intent.getStringExtra("chapterNameInEnglish")
        binding?.chapterNameInArabic?.text=intent.getStringExtra("chapterNameInArabic")
    }
    private fun initRycycler() {
        val adapter= VersesAdapter(readFiles())
        binding?.VersesRecycler?.adapter=adapter
    }

    private fun readFiles(): List<String> {
        return assets.open("quran/${chapterIndex}.txt").bufferedReader().use {
        it.readLines()}
        }
    }



