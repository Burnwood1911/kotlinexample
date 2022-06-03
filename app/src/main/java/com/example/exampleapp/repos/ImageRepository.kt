package com.example.exampleapp.repos

import android.content.Context
import android.net.Uri
import android.util.Log
import com.example.exampleapp.api.MyApi
import com.example.exampleapp.models.FImage
import com.example.exampleapp.utils.Converter
import com.example.exampleapp.utils.ImageDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext



class ImageRepository(private val api:MyApi, private val context: Context, private val imageDao: ImageDao) {


    private val converter = Converter()

    suspend fun getLocalImages(): List<FImage> {
        return  imageDao.getImages()
    }


     suspend fun getAllImages(): List<FImage> {

            val response = api.getImages()

            val empty = mutableListOf<FImage>()

            response.forEach { i -> empty.add(FImage(converter.encode(Uri.parse(i.download_url)))) }

            return  empty

        }
    }
