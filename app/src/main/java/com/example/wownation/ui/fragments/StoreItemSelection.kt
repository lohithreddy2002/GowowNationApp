package com.example.wownation.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.wownation.R
import com.example.wownation.databinding.FragmentStoreItemSelectionBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.snackbar.Snackbar


class StoreItemSelection : BottomSheetDialogFragment() {
lateinit var binding: FragmentStoreItemSelectionBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_store_item_selection, container, false)
    }

    override fun onStart() {
        super.onStart()
        binding = FragmentStoreItemSelectionBinding.bind(requireView())
        binding.language.setItems("Hindi","Telugu","English")
        binding.language.setOnItemSelectedListener { view, position, id, item ->
            Snackbar.make(view,""+item,Snackbar.LENGTH_SHORT).setAnimationMode(Snackbar.ANIMATION_MODE_SLIDE).show()

        }
        binding.close.setOnClickListener {
            dismiss()
        }
    }
}