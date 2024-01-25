package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.ActivityPimerEjercicio1Binding

class PimerEjercicioActivity1 : AppCompatActivity() {

    private lateinit var binding: ActivityPimerEjercicio1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPimerEjercicio1Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}