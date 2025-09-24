package com.example.islamiapp.fragments.Hadeth

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearSnapHelper
import com.example.islamiapp.databinding.FragmentHadethBinding
import com.example.islamiapp.fragments.Hadeth.HadethAdaper.HadethAdapter
import com.example.islamiapp.fragments.Hadeth.HadethDM.HadethDM
import com.example.islamiapp.fragments.Hadeth.Keywords.Keywords
import com.example.islamiapp.fragments.Hadeth.OnItemHadthClick.OnItemHadethClick

class HadethFragment: Fragment() {
    private lateinit var binding: FragmentHadethBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentHadethBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = HadethAdapter(readAhadeth())
        binding.hadethRecyclerView.adapter=adapter
          LinearSnapHelper().attachToRecyclerView(binding.hadethRecyclerView)
        adapter.onItemHadethClick= object : OnItemHadethClick{
            override fun onItemHadethClick(item: HadethDM) {
                val intent =Intent(context, HadethDetailsScreanActivity::class.java)
                intent.putExtra(Keywords.hadethNumberInEnglish,item.hadethNumber)
                intent.putExtra(Keywords.hadethTitle,item.title)
                intent.putExtra(Keywords.hadethContent,item.content)
                startActivity(intent)
            }

        }
    }
    fun readAhadeth(): ArrayList<HadethDM>{
        var hadethNumbercounter=0;
        val ahadeth = ArrayList<HadethDM>()
      var  hadeth = ArrayList<String>()
        val inputSream=requireActivity().assets.open("ahadeth.txt")
        val reader = inputSream.bufferedReader()
        var line = reader.readLine()
        while(line!=null){
            if(line.trim() != "#"){
                hadeth.add(line)
            }
            if(line.trim() == "#"){
                ++hadethNumbercounter;
                var title=hadeth[0]
                hadeth.removeAt(0)
                var content = hadeth.joinToString(separator = " ")
                ahadeth.add(HadethDM(title,content,"Hadeth ${hadethNumbercounter}"))
                hadeth.clear()
            }
            line=reader.readLine()
        }
        return ahadeth
    }
}