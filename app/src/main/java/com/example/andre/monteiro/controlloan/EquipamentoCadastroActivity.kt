package com.example.andre.monteiro.controlloan

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.andre.monteiro.controlloan.Equipamento
import com.example.andre.monteiro.controlloan.EquipamentoService
import com.example.andre.monteiro.controlloan.R
import kotlinx.android.synthetic.main.activity_cadastro_equipamento.*
import kotlinx.android.synthetic.main.login.*
import kotlinx.android.synthetic.main.toolbar.*

class EquipamentoCadastroActivity : AppCompatActivity() {
    private val context: Context get() = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_equipamento)
        title = "Adicionar Equipamento"

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        salvarEquipamento.setOnClickListener {
            val equipamento = Equipamento()
            equipamento.numeroEquipamento = numeroEquipamento.text.toString()
            equipamento.marca = marca.text.toString()
            equipamento.modelo = modelo.text.toString()

            taskAtualizar(equipamento)
        }
    }

    private fun taskAtualizar(equipamento: Equipamento) {
        // Thread para salvar a equipamento
        Thread {
            EquipamentoService.save(equipamento,context)
            runOnUiThread {
                // após cadastrar, voltar para activity anterior
                finish()
            }
        }.start()
    }
}
