package com.example.andre.monteiro.controlloan

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
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_tela_equipamento.*
import kotlinx.android.synthetic.main.activity_tela_equipamento.layoutMenuLateral
import kotlinx.android.synthetic.main.toolbar.*

class TelaEquipamentoActivity : DebugActivity(), NavigationView.OnNavigationItemSelectedListener  {
    private val context: Context get() = this
    private var equipamentos = listOf<Equipamento>()
    private var REQUEST_CADASTRO = 1
    private var REQUEST_REMOVE= 2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_equipamento)

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
        Thread {
            this.equipamentos = EquipamentoService.getEquipamentos(context)
            runOnUiThread {
                recyclerEquipamento?.adapter =
                    EquipamentoAdapter(equipamentos) { onClickEquipamento(it) }

            }
        }.start()
    }

    fun onClickEquipamento(equipamento: Equipamento) {
        Toast.makeText(context,"Clicou em ${equipamento.marca}",Toast.LENGTH_SHORT).show()
        val intent = Intent(context, EquipamentoActivity::class.java)
        intent.putExtra("Equipamentos", equipamento)
        startActivityForResult(intent, REQUEST_REMOVE)
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
        else if (id == R.id.action_adicionar) {
            // iniciar activity de cadastro
            val intent = Intent(context, EquipamentoCadastroActivity::class.java)
            startActivityForResult(intent, REQUEST_CADASTRO)
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
            R.id.nav_emprestimos -> {
                Toast.makeText(this, "Clicou em Empréstimos", Toast.LENGTH_SHORT).show()
                val intent = Intent(context, TelaEmprestimoActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_equipamentos -> {
                Toast.makeText(this, "Clicou em Equipamentos", Toast.LENGTH_SHORT).show()
                val intent = Intent(context, TelaEquipamentoActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_usuarios -> {
                Toast.makeText(this, "Clicou em Usuários", Toast.LENGTH_SHORT).show()
                val intent = Intent(context, TelaUsuarioActivity::class.java)
                startActivity(intent)
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