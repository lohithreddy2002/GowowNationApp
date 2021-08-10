package com.example.wownation.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.asLiveData
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wownation.*
import com.example.wownation.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var sadapter: StoreRecyclerAdapter
    private lateinit var binding: FragmentHomeBinding
    private lateinit var Yadapter:YourbooksRrecycleAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(requireView())

        loginmanager(requireContext()).getloginstatus.asLiveData().observe(viewLifecycleOwner, a)
        loginmanager(requireContext()).getloginstatus.asLiveData().removeObserver(a)

    }

    private val a = Observer<Int> {
        if (it == 0) {
            findNavController().navigate(R.id.action_homeFragment_to_onboardingFragment)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("values1", "it")
        Srecycle()
        Yrecycle()
        val a = listOf(Store(1,R.drawable.ebook,"Become an Instagram Pro",100,50),
            Store(2,R.drawable.ebook,"Become an LinkedIn Pro",200,100),
            Store(2,R.drawable.ebook,"Become an Youtube Pro",500,20))
        Yadapter.differ.submitList(a)
        sadapter.differ.submitList(a)
        sadapter.setOnItemClickListner{ _, image  ->
            val extras = FragmentNavigatorExtras(image to "imageitem")
            findNavController().navigate(
                R.id.action_homeFragment_to_storeItemFragment,
                null,
                null,
                extras
            )
        }

    }

    private fun Srecycle() {
        sadapter = StoreRecyclerAdapter()
        binding.storerecycle.apply {
            adapter = sadapter
            layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)

        }
        Log.d("values1","recycle")
    }
    private fun Yrecycle(){
        Yadapter = YourbooksRrecycleAdapter()
        binding.yourbooksrecycle.apply {
            adapter = Yadapter
            layoutManager =  LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        }
    }

}