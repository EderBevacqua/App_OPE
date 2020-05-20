package com.example.andre.monteiro.controlloan

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.*
import kotlinx.android.synthetic.main.login.*
import java.util.prefs.PreferenceChangeEvent

class MainActivity : DebugActivity() {

    private val context: Context get() = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
        campo_imagen.setImageResource(R.drawable.imagem_login)
        botao_login.setOnClickListener {onClickLogin() }

        var lembrar = Prefs.getBoleean("lembrar")
        var nomeUsuario = Prefs.getString("lembrarNome")
        var senha = Prefs.getString("lembrarSenha")
        campo_usuario.setText(nomeUsuario)
        campo_senha.setText(senha)
        checkLembrar.isChecked = lembrar
    }

    fun onClickLogin(){
        val valorUsuario = campo_usuario.text.toString()
        val valorSenha = campo_senha.text.toString()
        Prefs.setBoleean("lembrar", checkLembrar.isChecked)
        if (checkLembrar.isChecked) {
            Prefs.setString("lembrarNome", valorUsuario)
            Prefs.setString("lembrarSenha", valorSenha)
        } else {
            Prefs.setString("lembrarNome", "")
            Prefs.setString("lembrarSenha","")
        }

        //Toast.makeText(context, "$valorUsuario : $valorSenha", Toast.LENGTH_LONG).show()
        val intent = Intent(context, TelaInicialActivity::class.java)
        val params = Bundle()
        params.putString("nome", valorUsuario)
        intent.putExtras(params)
        intent.putExtra("numero", 10)
        startActivityForResult(intent, 1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            val result = data?.getStringExtra("result")
            Toast.makeText(context, "$result", Toast.LENGTH_LONG).show()
        }
    }
}