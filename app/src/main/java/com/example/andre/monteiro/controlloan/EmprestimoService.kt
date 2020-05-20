package com.example.andre.monteiro.controlloan

import android.content.Context
import android.util.Log
import com.example.andre.monteiro.controlloan.AndroidUtils
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URL

object EmprestimoService {

    val host = "https://ederbevacqua.pythonanywhere.com"
    val TAG = "WS_Emprestimos"

    fun getEmprestimos (context: Context): List<Emprestimo> {
        return if (AndroidUtils.isInternetDisponivel(context)) {
            val url = "$host/api/emprestimos"
            val json = URL(url).readText()
            Log.d(TAG, json)
            parserJson(json)
        } else {
            ArrayList()
        }
    }
    private inline fun<reified T> parserJson(json: String) : T{
        val type = object : TypeToken<T>(){}.type
        return Gson().fromJson<T>(json, type)
    }
}