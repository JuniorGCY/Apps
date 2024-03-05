package com.example.calculadoraimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.calculadoraimc.databinding.ActivityHomeBinding


class activity_Home : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var condicao: Boolean = false
        var imcFinal : Double = 0.00
        var classificacaoFinal : String = ""

        binding.botaoCalcularIMC.setOnClickListener {
           condicao = captarVazio(condicao)

            if (condicao == false) {
                //pass
            } else if (condicao == true){
                 imcFinal = calcularIMC(imcFinal)
                classificacaoFinal = classificacaoIMC(classificacaoFinal,imcFinal)
                binding.txtResultado.setText("Seu IMC é %.1f".format(imcFinal))
                binding.txtResultado2.setText("Seu estado é $classificacaoFinal")
            }
        }
    }

    fun captarVazio(condicao2 : Boolean) : Boolean {
        var condicao2_ = condicao2

        if (binding.editPeso.text.isEmpty()) {
            Toast.makeText(this,"Campo Peso está vazio, preencha",Toast.LENGTH_SHORT).show()
            condicao2_ = false
            return condicao2_
        } else if (binding.editAltura.text.isEmpty()) {
            Toast.makeText(this,"Campo Altura está vazio, preencha",Toast.LENGTH_SHORT).show()
            condicao2_ = false
            return condicao2_
        } else if (binding.editIdade.text.isEmpty()) {
            Toast.makeText(this,"Campo Idade está vazio, preencha",Toast.LENGTH_SHORT).show()
            condicao2_ = false
            return condicao2_
        } else if (binding.editSexo.text.isEmpty()) {
            Toast.makeText(this,"Campo Gênero está vazio, preencha",Toast.LENGTH_SHORT).show()
            condicao2_ = false
            return condicao2_
        } else {
            condicao2_ = true
            return condicao2_
        }
    }

    fun calcularIMC(imC : Double) : Double  {
        var iMC : Double = imC
        var peso : Double = binding.editPeso.text.toString().toDouble()
        var altura : Double = binding.editAltura.text.toString().toDouble()
        iMC = peso / (altura * altura)
        return iMC
    }

    fun classificacaoIMC(classificacao : String, imc : Double) : String {
        var classificacao_ = classificacao
        var imc_ = imc

        if (imc_ < 17.3) {
            classificacao_ = "Magreza"
            return classificacao_
        } else if (imc_ >= 17.3 && imc_ <= 25.5) {
            classificacao_ = "Normal"
            return classificacao_
        } else if (imc_ >= 25.5 && imc <= 29.7) {
            classificacao_ = "Sobrepeso"
            return classificacao_
        } else if (imc >= 29.7) {
            classificacao_ = "Obesidade"
            return classificacao_
        }
        return classificacao_
    }
}