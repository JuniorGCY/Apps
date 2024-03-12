package com.example.appdelivery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appdelivery.adapter.adapterProdutos
import com.example.appdelivery.databinding.ActivityHomeBinding
import com.example.appdelivery.model.Produto

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var adapterProdutos: adapterProdutos
    private val listaProdutos : MutableList<Produto> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityHomeBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val recyclerViewProdutos = binding.recyclerViewCatalogo
        recyclerViewProdutos.layoutManager = LinearLayoutManager(this)
        recyclerViewProdutos.setHasFixedSize(true)
        adapterProdutos = adapterProdutos(this, listaProdutos)
        recyclerViewProdutos.adapter = adapterProdutos

        catalogoLista()


    }

    private fun catalogoLista() {
        val produto1 = Produto("Bolo De Chocolate","Delicioso bolo de chocholate","R$10",R.drawable.bolo_de_chocolate)
        listaProdutos.add(produto1)
        val produto2 = Produto("Pudim", "Gostoso pudim de leite condesado", "R$5",R.drawable.pudim_de_leite)
        listaProdutos.add(produto2)
        val produto3 = Produto("Brigadeiro","Doce Brasileiro","R$2",R.drawable.brigadeiro)
        listaProdutos.add(produto3)
        val produto4 = Produto("Canjica","variações a se escolher","R$2-R$10",R.drawable.canjica)
        listaProdutos.add(produto4)
        val produto5 = Produto("Maça Do Amor", "Ótimo para presentear","R$2",R.drawable.maca_do_amor)
        listaProdutos.add(produto5)
        val produto6 = Produto("Mousse De Chocolate","com textura cremosa e aerada","R$4",R.drawable.chocolate_mousse)
        listaProdutos.add(produto6)
        val produto7 = Produto("Milk Shake", "Diversos Sabores disponiveis","R$7",R.drawable.milkshake)
        listaProdutos.add(produto7)
    }
}