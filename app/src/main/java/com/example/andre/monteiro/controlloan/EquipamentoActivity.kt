package com.example.andre.monteiro.controlloan

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_cadastro_equipamento.*
import kotlinx.android.synthetic.main.activity_equipamento.*
import kotlinx.android.synthetic.main.toolbar.*
import kotlinx.android.synthetic.main.activity_cadastro_equipamento.marca as marca1

class EquipamentoActivity : DebugActivity(){
    private val context: Context get() = this
    var equipamento: Equipamento? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_equipamento)

        if (intent.getSerializableExtra("Equipamentos") is Equipamento)
                equipamento = intent.getSerializableExtra("Equipamentos") as Equipamento
        Toast.makeText(context,equipamento?.marca,Toast.LENGTH_SHORT).show()

        setSupportActionBar(toolbar)
        supportActionBar?.title = equipamento?.marca
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        marcaEquip.text = equipamento?.marca

    }

    // método sobrescrito para inflar o menu na Actionbar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        // id do item clicado
        val id = item?.itemId
        // verificar qual item foi clicado
        // remover a disciplina no WS
        if  (id == R.id.action_remover) {
            // alerta para confirmar a remeção
            // só remove se houver confirmação positiva
            AlertDialog.Builder(this)
                .setTitle(R.string.app_name)
                .setMessage("Deseja excluir o equipamento?")
                .setPositiveButton("Sim") {
                        dialog, which ->
                    dialog.dismiss()
                    taskExcluir()
                }.setNegativeButton("Não") {
                        dialog, which -> dialog.dismiss()
                }.create().show()
        }
        // botão up navigation
        else if (id == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun taskExcluir() {
        if (this.equipamento != null && this.equipamento is Equipamento) {
            // Thread para remover a disciplina
            Thread {
                EquipamentoService.delete(this.equipamento as Equipamento, context)
                runOnUiThread {
                    // após remover, voltar para activity anterior
                    finish()
                }
            }.start()
        }
    }

}
