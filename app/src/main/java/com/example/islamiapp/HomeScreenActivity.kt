package com.example.islamiapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.islamiapp.databinding.ActivityHomeScreenBinding
import com.example.islamiapp.fragments.HadethFragment
import com.example.islamiapp.fragments.QuranFragment
import com.example.islamiapp.fragments.RadioFragment
import com.example.islamiapp.fragments.SebhaFragment

class HomeScreenActivity : AppCompatActivity() {
    private lateinit var binding:ActivityHomeScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_home_screen)
        binding=ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
    fun initViews(){
        binding.islamicBottomNavView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.navigation_quran->{pushFragments(QuranFragment())}
                R.id.navigation_hadeth->{pushFragments(HadethFragment())}
                R.id.navigation_sebha->{pushFragments(SebhaFragment())}
                R.id.navigation_radio->{pushFragments(RadioFragment())}
            }
            return@setOnItemSelectedListener true
        }
    }
    fun pushFragments(fragment:Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.islamic_fragment_container,fragment).commit()
    }
}