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
import kotlinx.android.synthetic.main.activity_tela_emprestimo.*
import kotlinx.android.synthetic.main.activity_tela_emprestimo.layoutMenuLateral
import kotlinx.android.synthetic.main.toolbar.*

class TelaEmprestimoActivity : DebugActivity(), NavigationView.OnNavigationItemSelectedListener  {
    private val context: Context get() = this
    private var emprestimos = listOf<Emprestimo>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_emprestimo)

        Toast.makeText(context, "Emprestimos", Toast.LENGTH_LONG).show()
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Emprestimos"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        configuraMenuLateral()
        recyclerEmprestimo?.layoutManager = LinearLayoutManager(context)
        recyclerEmprestimo?.itemAnimator = DefaultItemAnimator()
        recyclerEmprestimo?.setHasFixedSize(true)
    }

    override fun onResume() {
        super.onResume()
        taskEmprestimos()
    }

    fun taskEmprestimos() {
        Thread {
            this.emprestimos = EmprestimoService.getEmprestimos(context)
            runOnUiThread {
                recyclerEmprestimo?.adapter =
                    EmprestimoAdapter(emprestimos) { onClickEmprestimo(it) }

            }
        }.start()
    }

    fun onClickEmprestimo(emprestimo: Emprestimo) {
        Toast.makeText(context,"Clicou em ${emprestimo.nome}",Toast.LENGTH_SHORT).show()
        val intent = Intent(context, EquipamentoService::class.java)
        intent.putExtra("Emprestimos", emprestimo)
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

        EMmenu_lateral.setNavigationItemSelectedListener(this)
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