package com.example.exampleapp.ui

import androidx.lifecycle.*
import com.example.exampleapp.models.FImage
import com.example.exampleapp.repos.ImageRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ImageViewModel(private val repository: ImageRepository): ViewModel() {


    val imageList = MutableLiveData<List<FImage>>()

    fun getAllImages() {

        viewModelScope.launch {
            val result =  repository.getAllImages()

            imageList.value = result
        }
    }
}

