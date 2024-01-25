package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        configurarBotones()
    }

    private fun configurarBotones() {
        binding.btnActividad1.setOnClickListener {
            val intent = Intent(this@MainActivity, PimerEjercicioActivity1::class.java)
            startActivity(intent)
        }
        binding.btnActividad2.setOnClickListener {
            val intent = Intent(this@MainActivity, SegundoEjercicioActivity::class.java)
            startActivity(intent)
        }
        binding.btnActividad3.setOnClickListener {
            val intent = Intent(this@MainActivity, TercerEjercicioActivity::class.java)
            startActivity(intent)
        }
    }
}