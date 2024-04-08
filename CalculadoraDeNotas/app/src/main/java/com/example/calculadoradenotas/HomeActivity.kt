package com.example.calculadoradenotas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Toast
import com.example.calculadoradenotas.databinding.ActivityHomeBinding
import java.text.DecimalFormat

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private var mediaFinal : Double? = null
    private var aprovacao : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityHomeBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonCalcular.setOnClickListener {
            aprovacao =  calcularMedia()

            if (aprovacao == true) {
                binding.txtNotaFinal.text = "Sua média é ${String.format("%.1f",mediaFinal)}"
                binding.txtNotaFinal.setTextColor(getColor(R.color.green))
                binding.txtDetalhesNotas.visibility = View.VISIBLE
            } else if (aprovacao == false) {
                binding.txtNotaFinal.text = "Sua média é ${String.format("%.1f",mediaFinal)}"
                binding.txtNotaFinal.setTextColor(getColor(R.color.red))
                binding.txtDetalhesNotas.visibility = View.VISIBLE
            }
        }

        binding.txtDetalhesNotas.setOnClickListener {
            binding.progressBar.visibility = View.VISIBLE
            Toast.makeText(this,"Carregando informações",Toast.LENGTH_LONG).show()

            Handler(Looper.getMainLooper()).postDelayed({
                val intent = Intent(this@HomeActivity, DetalhesActivity::class.java)
                intent.putExtra("Nota1",binding.editTextNota1.text.toString())
                intent.putExtra("Nota2",binding.editTextNota2.text.toString())
                intent.putExtra("Nota3",binding.editTextNota3.text.toString())
                intent.putExtra("Nota4",binding.editTextNota4.text.toString())
                intent.putExtra("MédiaFinal",mediaFinal.toString())
                intent.putExtra("Aprovação",aprovacao.toString())
                intent.putExtra("Faltas",binding.editTextNumerodFaltas.text.toString())
                startActivity(intent)
            },3000)
        }

    }

    fun calcularMedia() : Boolean {
        var nota1 = binding.editTextNota1.text.toString().toDouble()
        var nota2 = binding.editTextNota2.text.toString().toDouble()
        var nota3 = binding.editTextNota3.text.toString().toDouble()
        var nota4 = binding.editTextNota4.text.toString().toDouble()
        var numero_de_faltas = binding.editTextNumerodFaltas.text.toString().toInt()
        var media_ = (nota1 + nota2 + nota3 + nota4) / 4

        if (media_ <7 && numero_de_faltas <= 20) {
            mediaFinal = media_
            aprovacao = false
        } else if (media_ >=7 && numero_de_faltas <= 20) {
            mediaFinal = media_
            aprovacao = true
        } else if (media_ < 7 && numero_de_faltas> 20) {
            mediaFinal = media_
            aprovacao = false
        } else if (media_ >=7 && numero_de_faltas > 20) {
            mediaFinal = media_
            aprovacao = false
        }
        return aprovacao
    }
}