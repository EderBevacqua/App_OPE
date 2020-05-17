package com.example.andre.monteiro.controlloan

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.andre.monteiro.controlloan.R.layout.adapter_equipamento
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso


class EquipamentoAdapter (
    val equipamentos: List<Equipamento>,
    val onClick: (Equipamento) -> Unit): RecyclerView.Adapter<EquipamentoAdapter.EquipamentosViewHolder> (){

    class EquipamentosViewHolder(view: View): RecyclerView.ViewHolder(view){
        val cardNome: TextView
        val cardImg: ImageView
        val cardProgress: ProgressBar
        val cardView: CardView

        init {
            cardNome = view.findViewById<TextView>(R.id.cardNome)
            cardImg = view.findViewById<ImageView>(R.id.cardImg)
            cardProgress = view.findViewById<ProgressBar>(R.id.cardProgress)
            cardView = view.findViewById<CardView>(R.id.card_equipamentos)
        }
    }

    override fun getItemCount () = this.equipamentos.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EquipamentosViewHolder {
        val view  = LayoutInflater.from (parent.context).inflate(adapter_equipamento, parent, false)

        val holder = EquipamentosViewHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: EquipamentosViewHolder, position: Int) {
       val context = holder.itemView.context

        val equipamento = equipamentos[position]

        holder.cardNome.text = equipamento.Equipamento

        holder.cardProgress. visibility = View.VISIBLE

        Picasso.with(context).load(equipamento.foto).fit() .into(
                    holder.cardImg,
                    object: Callback{
                        override fun onSuccess() {
                          holder.cardProgress.visibility = View.GONE
                        }
                        override fun onError (){
                            holder.cardProgress.visibility = View.GONE
                        }
                    }
                )
                holder.itemView.setOnClickListener{onClick(equipamento)}
    }
}