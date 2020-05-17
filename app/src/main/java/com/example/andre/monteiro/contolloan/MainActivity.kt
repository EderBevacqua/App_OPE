package com.example.andre.monteiro.controlloan

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.login_constraint.*

class MainActivity : DebugActivity() {

    private val context: Context get() = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_constraint)
        campo_imagen.setImageResource(R.drawable.imagem_login)
        botao_login.setOnClickListener {onClickLogin() }
        progressBar.visibility = View.INVISIBLE
    }

    fun onClickLogin(){
        val valorUsuario = campo_usuario.text.toString()
        val valorSenha = campo_senha.text.toString()
        Toast.makeText(context, "$valorUsuario : $valorSenha", Toast.LENGTH_LONG).show()
        val intent = Intent(context, TelaInicialActivity::class.java)
        val params = Bundle()
        params.putString("nome", "Seja bem  vindo")
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

