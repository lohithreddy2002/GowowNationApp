package com.example.wownation.ui.fragments

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.wownation.R
import com.example.wownation.databinding.FragmentStoreItemBinding


class StoreItemFragment : Fragment() {

lateinit var binding: FragmentStoreItemBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_store_item, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val animation = TransitionInflater.from(requireContext()).inflateTransition(android.R.transition.move)
        sharedElementEnterTransition =animation
        sharedElementReturnTransition = animation
    }

    override fun onStart() {

        super.onStart()
        binding = FragmentStoreItemBinding.bind(requireView())
        binding.materialButton.setOnClickListener {
            findNavController().navigate(R.id.action_storeItemFragment_to_storeItemSelection)
        }
    }
}