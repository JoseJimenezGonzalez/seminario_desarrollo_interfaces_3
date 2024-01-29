package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.myapplication.databinding.ActivitySegundoEjercicioBinding
import com.example.myapplication.databinding.ActivityTercerEjercicioBinding

class TercerEjercicioActivity : AppCompatActivity() {


    private lateinit var binding: ActivityTercerEjercicioBinding
    private lateinit var countDownTimer: CountDownTimer
    private var tiempoRestante: Long = 5000
    private var estadoSemaforo: Int = 0  // 0: verde, 1: amarillo, 2: rojo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTercerEjercicioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inicializar el contador regresivo
        countDownTimer = object : CountDownTimer(tiempoRestante, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                tiempoRestante = millisUntilFinished
                actualizarSemaforo()
            }

            override fun onFinish() {
                // Reiniciar el temporizador al llegar a cero
                tiempoRestante = 5000  // Inicializar tiempo a 5 segundos para el próximo ciclo
                countDownTimer.start()
            }
        }

        // Iniciar el contador regresivo
        countDownTimer.start()
    }

    private fun actualizarSemaforo() {
        when {
            tiempoRestante > 2000 && estadoSemaforo != 0 -> {
                // Cambiar a verde
                binding.ivFoto.setImageResource(R.drawable.semaforo_verde)
                estadoSemaforo = 0
            }
            tiempoRestante in 1000..2000 && estadoSemaforo != 1 -> {
                // Cambiar a amarillo
                binding.ivFoto.setImageResource(R.drawable.semaforo_amarillo)
                estadoSemaforo = 1
            }
            tiempoRestante in 0..1000 && estadoSemaforo != 2 -> {
                // Cambiar a rojo
                binding.ivFoto.setImageResource(R.drawable.semaforo_rojo)
                estadoSemaforo = 2
            }
        }
    }
}