package com.example.calculadoradenotas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.calculadoradenotas.databinding.ActivityDetalhesBinding
import java.text.DecimalFormat

class DetalhesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetalhesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDetalhesBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        val nota1_ = intent.getStringExtra("Nota1")
        val nota2_ = intent.getStringExtra("Nota2")
        val nota3_ = intent.getStringExtra("Nota3")
        val nota4_ = intent.getStringExtra("Nota4")
        val faltas_ = intent.getStringExtra("Faltas")
        var mediaFinal_ = intent.getStringExtra("MédiaFinal")
        var mediaConvert : Double = 0.0
        val aprovacao_ = intent.getStringExtra("Aprovação")

        mediaConvert = mediaFinal_.toString().toDouble()


        //Notas do Aluno
        binding.txtNota1.setText("Nota 1: $nota1_")
        binding.txtNota2.setText("Nota 1: $nota2_")
        binding.txtNota3.setText("Nota 1: $nota3_")
        binding.txtNota4.setText("Nota 1: $nota4_")
        binding.txtNumerodeFaltas.text = "Numero De Faltas: $faltas_"
        binding.txtMedia.text = "Média Final: ${String.format("%.1f",mediaConvert)}"
        if (aprovacao_ == "false") {
            binding.txtAprovacao.text = "Situação: Reprovado"
        } else if (aprovacao_ == "true") {
            binding.txtAprovacao.text = "Situação: Aprovado"
        }

        binding.buttonVoltar.setOnClickListener {
            startActivity(Intent(this@DetalhesActivity, HomeActivity::class.java))
            finish()
        }
    }
}