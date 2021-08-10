package com.example.wownation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewFactory(private val repo:loginmanager): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(viewModel::class.java)) {
            return viewModel(repo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}