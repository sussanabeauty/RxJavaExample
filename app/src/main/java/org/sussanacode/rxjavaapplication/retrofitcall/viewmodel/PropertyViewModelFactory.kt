package org.sussanacode.rxjavaapplication.retrofitcall.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.sussanacode.rxjavaapplication.retrofitcall.api.ApiService

class PropertyViewModelFactory (val apiService: ApiService): ViewModelProvider.NewInstanceFactory(){

    override fun <T: ViewModel?> create(modelClass: Class<T>): T {
        return PropertyViewModel(apiService) as T
    }
}