package com.example.wownation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.wownation.R
import com.example.wownation.databinding.FragmentLoginBinding
import com.example.wownation.ui.activity.MainActivity
import com.google.android.material.snackbar.Snackbar


class LoginFragment : Fragment() {
lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onStart() {

        super.onStart()
    binding = FragmentLoginBinding.bind(requireView())
        val userViewModel = (activity as MainActivity).viewmodel
        binding.login.setOnClickListener {
            if(binding.email.text.toString() == "" || binding.password.text.toString() == "" ){
                Snackbar.make(requireView(),"Enter the rewfsdnv",Snackbar.LENGTH_SHORT).show()
            }
            else{
                findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
                userViewModel.set()
            }


        }

        binding.signup.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_signupFragment)
        }
    }


}