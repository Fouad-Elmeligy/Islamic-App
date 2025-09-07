package com.example.islamiapp.Activitys

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.islamiapp.R
import com.example.islamiapp.databinding.ActivityHomeScreenBinding
import com.example.islamiapp.fragments.HadethFragment
import com.example.islamiapp.fragments.RadioFragment
import com.example.islamiapp.fragments.SebhaFragment
import com.example.islamiapp.fragments.quran.QuranFragment

class HomeScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_home_screen)
        binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        pushFragments(QuranFragment())
        initViews()

    }

    fun initViews() {
        binding.islamicBottomNavView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_quran -> {
                    pushFragments(QuranFragment())
                }

                R.id.navigation_hadeth -> {
                    pushFragments(HadethFragment())
                }

                R.id.navigation_sebha -> {
                    pushFragments(SebhaFragment())
                }

                R.id.navigation_radio -> {
                    pushFragments(RadioFragment())
                }
            }
            return@setOnItemSelectedListener true
        }
    }

    fun pushFragments(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.islamic_fragment_container, fragment)
            .commit()
    }
}