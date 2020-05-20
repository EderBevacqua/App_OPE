package com.example.andre.monteiro.controlloan

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class EmprestimoAdapter (
    val emprestimos: List<Emprestimo>,
    val onClick: (Emprestimo) -> Unit):
    RecyclerView.Adapter<EmprestimoAdapter.EmprestimosViewHolder>() {

    class EmprestimosViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val cardNome: TextView
        val cardDtEmprestimo: TextView
        val cardDtDevolucao: TextView
        var cardView: CardView
        init {
            cardNome = view.findViewById<TextView>(R.id.cardNome)
            cardDtEmprestimo = view.findViewById<TextView>(R.id.cardDtEmprestimo)
            cardDtDevolucao = view.findViewById<TextView>(R.id.cardDtDevolucao)
            cardView = view.findViewById<CardView>(R.id.card_emprestimos)
        }
    }
    override fun getItemCount() = this.emprestimos.size
    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int): EmprestimosViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_emprestimo, parent, false)
        val holder = EmprestimosViewHolder(view)
        return holder
    }
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: EmprestimosViewHolder, position: Int) {
        val emprestimo = emprestimos[position]
        holder.cardNome.text = "Nome solicitante: " + emprestimo.nome
        holder.cardDtEmprestimo.text = "Data Emprestimo: " + emprestimo.dtEmprestimo
        holder.cardDtDevolucao.text = "Data Devolução: " + emprestimo.dtDevolucao
        holder.itemView.setOnClickListener{onClick(emprestimo)}
    }
}