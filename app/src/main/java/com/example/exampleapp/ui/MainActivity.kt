package com.example.exampleapp.ui

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import com.example.exampleapp.R
import com.example.exampleapp.models.FImage
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {
    private val viewModel: ImageViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val textSpace = findViewById<TextView>(R.id.mytext)

        GlobalScope.launch {



            viewModel.getAllImages()
            println(viewModel.imageList.value?.get(0)?.image)

        }





    }


}


