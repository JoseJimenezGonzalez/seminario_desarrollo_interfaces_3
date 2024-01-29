package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.ActivitySegundoEjercicioBinding

class SegundoEjercicioActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySegundoEjercicioBinding

    private var isPressedButton = false

    private lateinit var countDownTimer: CountDownTimer
    private var tiempoRestante: Long = 2000

    val listaCartas = listOf(
        Carta(R.drawable.card_2, R.drawable.back_card, false),
        Carta(R.drawable.card_4, R.drawable.back_card, false),
        Carta(R.drawable.card_joker, R.drawable.back_card, false)
    )


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
                // Acciones a realizar cuando el contador llega a cero
                binding.ivPrimera.setImageResource(R.drawable.back_card)
                binding.ivSegunda.setImageResource(R.drawable.back_card)
                binding.ivTercera.setImageResource(R.drawable.back_card)
                isPressedButton = false
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
    }
}