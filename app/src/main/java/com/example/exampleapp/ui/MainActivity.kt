package com.example.exampleapp.ui

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.exampleapp.api.MyApi
import com.example.exampleapp.R
import com.example.exampleapp.models.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject


class MainActivity : AppCompatActivity() {
    private val api by inject<MyApi>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = findViewById<TextView>(R.id.name)
        val email = findViewById<TextView>(R.id.email)
        val address = findViewById<TextView>(R.id.address)
        val phone = findViewById<TextView>(R.id.phone)
        val website = findViewById<TextView>(R.id.website)

        fun setUser(user: User) {
            name.text = user.name
            email.text = user.email
            address.text = user.address.street
            phone.text = user.phone
            website.text = user.website

        }

        lifecycleScope.launch(Dispatchers.Main) { api.getUser().body()?.let {  setUser(it) } }
    }

}


