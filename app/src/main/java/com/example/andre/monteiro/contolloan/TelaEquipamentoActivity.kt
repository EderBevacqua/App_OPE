package com.example.andre.monteiro.contolloan

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.andre.monteiro.controlloan.*
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_tela_equipamento.*
import kotlinx.android.synthetic.main.activity_tela_equipamento.layoutMenuLateral
import kotlinx.android.synthetic.main.activity_tela_inicial_acitivity.*
import kotlinx.android.synthetic.main.toolbar.*

class TelaEquipamentoActivity : DebugActivity(), NavigationView.OnNavigationItemSelectedListener  {

    private val context: Context get() = this

    private var equipamentos = listOf<Equipamento>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_equipamento)

        val args: Bundle? = intent.extras
        val nome = args?.getString("nome")
        val numero = intent.getIntExtra("nome", 0)

        Toast.makeText(context, "Equipamentos", Toast.LENGTH_LONG).show()
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Equipamentos"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        configuraMenuLateral()
        recyclerEquipamento?.layoutManager = LinearLayoutManager(context)
        recyclerEquipamento?.itemAnimator = DefaultItemAnimator()
        recyclerEquipamento?.setHasFixedSize(true)
    }

    override fun onResume() {
        super.onResume()
        taskEquipamentos()
    }

    fun taskEquipamentos() {
        equipamentos = EquipamentoService.getEquipamentos(context)
        recyclerEquipamento?.adapter = EquipamentoAdapter(equipamentos) { onClickEquipamento(it) }
    }

    fun onClickEquipamento(equipamento: Equipamento) {
       Toast.makeText(context,"Clicou em ${equipamento.Equipamento}",Toast.LENGTH_SHORT).show()
        val intent = Intent(context, EquipamentoService::class.java)
        intent.putExtra("Equipamentos", equipamento)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.action_buscar) {
            Toast.makeText(this,"clicou em buscar", Toast.LENGTH_LONG).show()
        }
        else if (id == R.id.action_atualizar) {
            Toast.makeText(this,"clicou em atualizar", Toast.LENGTH_LONG).show()
        }
        else if (id == R.id.action_config) {
            Toast.makeText(this, "clicou em configurações", Toast.LENGTH_LONG).show()
        }
        else if (id == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun configuraMenuLateral() {
        var toogle = ActionBarDrawerToggle(
            this,
            layoutMenuLateral,
            toolbar,
            R.string.nav_open,
            R.string.nav_close )
        layoutMenuLateral.addDrawerListener(toogle)
        toogle.syncState()

        Emenu_lateral.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.nav_dashboard -> {
                Toast.makeText(this, "Clicou em Dashboard", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_itens -> {
                Toast.makeText(this, "Clicou em Item", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_calendario -> {
                Toast.makeText(this, "Clicou em Calendario", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_contato -> {
                Toast.makeText(this, "Clicou em Contato", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_configuracao -> {
                Toast.makeText(this, "Clicou em Configuração", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_sair -> {
                Toast.makeText(this, "Clicou em sair", Toast.LENGTH_SHORT).show()
                val intent = Intent(context, MainActivity::class.java)
                startActivity(intent)
            }
        }
        layoutMenuLateral.closeDrawer(GravityCompat.START)
        return true
    }

}