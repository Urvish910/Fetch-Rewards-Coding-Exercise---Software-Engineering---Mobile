package com.example.fetchrewardscodingexercise_urvishpatel.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.fetchrewardscodingexercise_urvishpatel.repo.Repository

class MainViewModelFactory(val repo:Repository):ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repo) as T
    }
}