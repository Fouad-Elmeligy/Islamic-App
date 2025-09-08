package com.example.islamiapp.fragments.Hadeth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.islamiapp.databinding.ActivityHadethDetailsScreanBinding
import com.example.islamiapp.fragments.Hadeth.Keywords.Keywords


class HadethDetailsScreanActivity : AppCompatActivity() {
    lateinit var binding: ActivityHadethDetailsScreanBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
binding= ActivityHadethDetailsScreanBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getHadethInfo()
        binding.backButton.setOnClickListener {
            finish()
        }
    }

    private fun getHadethInfo() {
        binding.hadethNameInEnglish.text=intent.getStringExtra(Keywords.hadethNumberInEnglish)
        binding.hadethNameInArabic.text=intent.getStringExtra(Keywords.hadethTitle)
        binding.hadethContent.text=intent.getStringExtra(Keywords.hadethContent)

    }
}