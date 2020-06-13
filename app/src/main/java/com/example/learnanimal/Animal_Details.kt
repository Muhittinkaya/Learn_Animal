package com.example.learnanimal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_animal__details.*
import kotlinx.android.synthetic.main.animal_ticket.*

class Animal_Details : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal__details)

        val bundle: Bundle? = intent.extras
        val name = bundle?.getString("name")
        val desc = bundle?.getString("description")
        val image = bundle?.getInt("image")

        imgAnimal.setImageResource(image!!)
        txtViewName.text = name
        txtViewDesc.text = desc

    }
}
