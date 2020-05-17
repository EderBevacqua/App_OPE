package com.example.andre.monteiro.contolloan

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.andre.monteiro.controlloan.*
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_equipamento.*
import kotlinx.android.synthetic.main.activity_equipamento.*
import kotlinx.android.synthetic.main.toolbar.*

class EquipamentoActivity : DebugActivity() {

    var equipamento : Equipamento? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_equipamento)

        equipamento = intent.getSerializableExtra("Equipamento") as? Equipamento

        setSupportActionBar(toolbar)
        supportActionBar?.title = equipamento?.Equipamento
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        nomeEquipamento.text = equipamento?.Equipamento
        Picasso.with(this).load(equipamento?.foto).fit().into(imagemEquipamento,
            object : com.squareup.picasso.Callback {
                override fun onSuccess() {}
                override fun onError() {}
            })
    }
}
