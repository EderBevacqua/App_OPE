package com.example.andre.monteiro.controlloan

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class UsuarioAdapter (
    val usuarios: List<Usuario>,
    val onClick: (Usuario) -> Unit):
    RecyclerView.Adapter<UsuarioAdapter.UsuariosViewHolder>() {

    class UsuariosViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val cardIdUsuario: TextView
        val cardNome: TextView
        val cardEmail: TextView
        //val cardImg : ImageView
        //var cardProgress: ProgressBar
        var cardView: CardView
        init {
            cardIdUsuario = view.findViewById<TextView>(R.id.cardIdUsuario)
            cardNome = view.findViewById<TextView>(R.id.cardNome)
            cardEmail = view.findViewById<TextView>(R.id.cardEmail)
            cardView = view.findViewById<CardView>(R.id.card_usuarios)
        }
    }
    override fun getItemCount() = this.usuarios.size
    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int): UsuariosViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_usuario, parent, false)
        val holder = UsuariosViewHolder(view)
        return holder
    }
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: UsuariosViewHolder, position: Int) {
        //val context = holder.itemView.context

        val usuario = usuarios[position]
        holder.cardIdUsuario.text = "Id Usuário: " + usuario.id_usuario
        holder.cardNome.text = "Nome: " + usuario.nome
        holder.cardEmail.text = "Email: " + usuario.email
        holder.itemView.setOnClickListener{onClick(usuario)}
    }
}