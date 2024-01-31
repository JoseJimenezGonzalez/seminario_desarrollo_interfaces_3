package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.ImageView
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.ActivitySegundoEjercicioBinding

class SegundoEjercicioActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySegundoEjercicioBinding

    private var isPressedButton = false

    private lateinit var countDownTimer: CountDownTimer
    private var tiempoRestante: Long = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySegundoEjercicioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inicializar el contador regresivo
        countDownTimer = object : CountDownTimer(tiempoRestante, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                tiempoRestante = millisUntilFinished
            }

            override fun onFinish() {
                recreate()
            }
        }

        configurarBotones()
    }

    private fun configurarBotones() {
        binding.ivPrimera.setOnClickListener {
            if (!isPressedButton){
                // Iniciar el contador regresivo
                isPressedButton = true
                countDownTimer.start()
                binding.ivPrimera.setImageResource(R.drawable.card_2)
            }
        }
        binding.ivSegunda.setOnClickListener {
            if (!isPressedButton){
                // Iniciar el contador regresivo
                isPressedButton = true
                countDownTimer.start()
                binding.ivSegunda.setImageResource(R.drawable.card_4)
            }
        }
        binding.ivTercera.setOnClickListener {
            if (!isPressedButton){
                // Iniciar el contador regresivo
                isPressedButton = true
                countDownTimer.start()
                binding.ivTercera.setImageResource(R.drawable.card_joker)
            }
        }

        binding.ivBavk.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}