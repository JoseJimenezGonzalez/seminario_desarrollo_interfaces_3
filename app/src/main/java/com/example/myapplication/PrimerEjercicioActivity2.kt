package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.ActivityPrimerEjercicio2Binding

class PrimerEjercicioActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityPrimerEjercicio2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPrimerEjercicio2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivBavk.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}