package com.example.andre.monteiro.controlloan

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_tela_inicial.*
import kotlinx.android.synthetic.main.menu_lateral_cabecalho.*
import kotlinx.android.synthetic.main.toolbar.*

class TelaInicialActivity : DebugActivity(), NavigationView.OnNavigationItemSelectedListener{

    private val context: Context get() = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)
        imageButtonEquip.setOnClickListener {
        }
        imageButtonEquip.setOnClickListener {onClickimageButtonEquip() }
        val args = intent.extras
        val nome = args?.getString("nome")
        Toast.makeText(context, "Bem Vindo $nome", Toast.LENGTH_LONG).show()
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Painel"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        configuraMenuLateral()
    }

    private fun onClickimageButtonEquip() {
        Toast.makeText(context, "Equipamentos", Toast.LENGTH_SHORT).show()
        val intent = Intent(context, TelaEquipamentoActivity::class.java)
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
        menu_lateral.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.nav_painel -> {
                Toast.makeText(this, "Clicou em Painel", Toast.LENGTH_SHORT).show()
                val intent = Intent(context, TelaInicialActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_emprestimos -> {
                Toast.makeText(this, "Clicou em Empréstimos", Toast.LENGTH_SHORT).show()
                val intent = Intent(context, TelaEmprestimoActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_solicitarEmrpestimo -> {
                Toast.makeText(this, "Clicou em Solicitar Emrpestimo", Toast.LENGTH_SHORT).show()
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
            R.id.nav_localizacao -> {
                startActivity(Intent(this, MapasActivity::class.java))
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


