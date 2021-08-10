package com.example.wownation.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.example.wownation.R
import com.example.wownation.databinding.FragmentOnboardingBinding
import com.example.wownation.viewpageradapter
import com.example.wownation.viewpagerdata

class OnboardingFragment : Fragment() {
lateinit var binding: FragmentOnboardingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val supportActionBar = (activity as AppCompatActivity?)!!.supportActionBar
        supportActionBar?.hide()
        Log.d("values","12")

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_onboarding, container, false)
    }

    override fun onStart() {
        super.onStart()
        binding = FragmentOnboardingBinding.bind(requireView())
        val tabla = binding.wormDotsIndicator
        val images = listOf(
            viewpagerdata(
                R.drawable.ic_undraw_bookshelves_re_lxoy__1_,
                "Welcome to The biggest Bookstore in all over India"
            ),
            viewpagerdata(R.drawable.ic_undraw_book_lover_mkck, "Some text"),
            viewpagerdata(R.drawable.ic_undraw_audio_player_re_cl20__1_, "text")
        )
        val adapter = viewpageradapter(images)
        val viewpager = binding.viewPager2
        viewpager.adapter = adapter
        tabla.setViewPager2(viewpager)

        binding.getstarted.setOnClickListener {
findNavController().navigate(R.id.action_onboardingFragment_to_loginFragment)
        }

    }
}