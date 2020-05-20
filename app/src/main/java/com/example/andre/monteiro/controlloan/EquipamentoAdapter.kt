package com.example.andre.monteiro.controlloan

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class EquipamentoAdapter (
    val equipamentos: List<Equipamento>,
    val onClick: (Equipamento) -> Unit):
    RecyclerView.Adapter<EquipamentoAdapter.EquipamentosViewHolder>() {

    class EquipamentosViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val cardNumeroEquipamento: TextView
        val cardMarca: TextView
        val cardModelo: TextView
        var cardView: CardView
        init {
            cardNumeroEquipamento = view.findViewById<TextView>(R.id.cardNumeroEquipamento)
            cardMarca = view.findViewById<TextView>(R.id.cardMarca)
            cardModelo = view.findViewById<TextView>(R.id.cardModelo)
            cardView = view.findViewById<CardView>(R.id.card_equipamentos)
        }
    }
    override fun getItemCount() = this.equipamentos.size
    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int): EquipamentosViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_equipamento, parent, false)
        val holder = EquipamentosViewHolder(view)
        return holder
    }
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: EquipamentosViewHolder, position: Int) {
        val equipamento = equipamentos[position]
        holder.cardNumeroEquipamento.text = "Número Equipamento: " + equipamento.numeroEquipamento
        holder.cardMarca.text = "Marca: " + equipamento.marca
        holder.cardModelo.text = "Modelo: " + equipamento.modelo
        holder.itemView.setOnClickListener{onClick(equipamento)}
    }
}