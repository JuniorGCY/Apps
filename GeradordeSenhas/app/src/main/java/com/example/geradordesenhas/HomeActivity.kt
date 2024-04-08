package com.example.geradordesenhas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.geradordesenhas.databinding.ActivityHomeBinding
import kotlin.random.Random
import kotlin.random.nextInt

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private val alfabeto = arrayOf(
        "A","B","C","D","E","F","G","H","I","J",
        "K","L","M","N","O","P","Q","R","S","T",
        "U","V","W","X","Y","Z"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonGerarSenha.setOnClickListener {
            val letraAleatoria1 = alfabeto.random()
            val letraaleatoria2 = alfabeto.random()
            val letraAleatoria3 = alfabeto.random()
            val numero = Random.nextInt(100..9999)

            binding.resultadoSenha.text = "$letraAleatoria1$letraaleatoria2$letraAleatoria3 - $numero"
        }
    }
}