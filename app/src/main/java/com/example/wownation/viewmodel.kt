package com.example.wownation

import android.content.Context
import android.util.Log
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.*
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class viewModel(private val loginmanager: loginmanager):ViewModel() {
    fun set(){
        viewModelScope.launch {
            loginmanager.setloginstatus()
        }

    }
}