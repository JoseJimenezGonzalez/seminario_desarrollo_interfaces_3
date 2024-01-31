package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.ActivityPimerEjercicio1Binding

class PimerEjercicioActivity1 : AppCompatActivity() {

    private lateinit var binding: ActivityPimerEjercicio1Binding

    private lateinit var countDownTimer: CountDownTimer
    private var tiempoRestante: Long = 10000  // Tiempo en milisegundos (en este ejemplo, 60 segundos)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPimerEjercicio1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inicializar el contador regresivo
        countDownTimer = object : CountDownTimer(tiempoRestante, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                tiempoRestante = millisUntilFinished
                actualizarContador()
            }

            override fun onFinish() {
                // Acciones a realizar cuando el contador llega a cero
                val intent = Intent(this@PimerEjercicioActivity1, PrimerEjercicioActivity2::class.java)
                startActivity(intent)

            }
        }

        // Iniciar el contador regresivo
        countDownTimer.start()
    }
    private fun actualizarContador() {
        val segundos = tiempoRestante / 1000
        binding.tvCuentaAtras.text = "$segundos" + " s"
    }
}