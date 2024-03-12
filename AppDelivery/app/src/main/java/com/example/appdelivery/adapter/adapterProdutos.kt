package com.example.appdelivery.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.appdelivery.databinding.CatalogoItemBinding
import com.example.appdelivery.model.Produto
import de.hdodenhof.circleimageview.CircleImageView

class adapterProdutos (private val context: Context, private val listaProdutos: MutableList<Produto>) :
    RecyclerView.Adapter<adapterProdutos.ProdutoViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutoViewHolder {
        val itemLista = CatalogoItemBinding.inflate(LayoutInflater.from(context),parent,false)
        return ProdutoViewHolder(itemLista)
    }

    override fun getItemCount() = listaProdutos.size

    override fun onBindViewHolder(holder: ProdutoViewHolder, position: Int) {
        holder.txtTitulo.text = listaProdutos[position].titulo
        holder.txtDescricao.text = listaProdutos[position].descricao
        holder.txtPreco.text = listaProdutos[position].preco
        holder.txtFoto.setImageResource(listaProdutos[position].foto)
    }

    inner class ProdutoViewHolder(binding: CatalogoItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val txtTitulo = binding.tituloItem
        val txtDescricao = binding.descricaoItem
        val txtPreco = binding.precoItem
        val txtFoto = binding.fotoItem

    }
}