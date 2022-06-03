package com.example.exampleapp.ui

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.exampleapp.api.MyApi
import com.example.exampleapp.R
import com.example.exampleapp.models.User
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {
    private val viewModel: UserViewModel by viewModel()

   private  val name by lazy { findViewById<TextView>(R.id.name) }
   private  val email by lazy { findViewById<TextView>(R.id.email) }
   private  val address by lazy { findViewById<TextView>(R.id.address) }
   private  val phone by lazy { findViewById<TextView>(R.id.phone) }
   private  val website by lazy { findViewById<TextView>(R.id.website) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn_get_user)?.setOnClickListener{
            findViewById<TextInputEditText>(R.id.user_id)?.text.toString().let { id ->
                viewModel.getUser(id.toInt())
            }
        }

        viewModel.user.observe(this){
            setUser(it)
        }
    }

    fun setUser(user: User) {
        name.text = user.name
        email.text = user.email
        address.text = user.address.street
        phone.text = user.phone
        website.text = user.website

    }
}


