package com.example.islamiapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islamiapp.databinding.FragmentSebhaBinding

class SebhaFragment : Fragment() {
    var flage1 = true
    var flage2 = false
    var flage3 = false
    var tasbicCounter = 0
    var beadAngle = 360f / 33f
    private lateinit var binding: FragmentSebhaBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSebhaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
binding.tasbih.text="سبحان الله"
        binding.tasbihCounter.text="0"
        setClick()
    }

    fun setClick() {
        binding.sebhaBody.setOnClickListener {
            rotateSebha()
        }
    }
    fun rotateSebha(){
        var newRotation = binding.sebhaBody.rotation+10.5f
        binding.sebhaBody.animate().rotation(newRotation).duration=400
        checkCounter()
    }

    fun checkCounter() {
        ++tasbicCounter
        if (tasbicCounter == 34) {
            editTasbih()
            tasbicCounter = 0;
        }
        binding.tasbihCounter.text = tasbicCounter.toString()


    }

    private fun editTasbih() {
        if (flage1) {
            binding.tasbih.text="الحمد لله"
            flage2=true
            flage1=false
        }else if(flage2){
            binding.tasbih.text="الله اكبر"
            flage3=true
            flage2=false
        }else if(flage3){
            binding.tasbih.text="سبحان الله"
            flage1=true
            flage3=false
        }
    }
}