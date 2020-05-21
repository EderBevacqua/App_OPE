package com.example.andre.monteiro.controlloan

import android.content.Context
import android.provider.CalendarContract
import android.util.Log
import android.widget.Toast
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONArray
import java.net.URL
import kotlin.Result.Companion.success

object EquipamentoService {
    val host = "https://ederbevacqua.pythonanywhere.com"
    val TAG = "WS_Equipamentos"

    fun getEquipamentos(context: Context): List<Equipamento> {
        return if (AndroidUtils.isInternetDisponivel(context)) {
            val url = "$host/api/equipamentos"
            val json = HttpHelper.get(url)
            val equipamentos = parserJson<List<Equipamento>>(json)
            for (e in equipamentos){
                saveOffline(e)
            }
            //Log.d(TAG, json)
            return equipamentos
        } else {
            var dao = DatabaseManager.getEquipamentoDAO()
            dao.findAll()
        }
    }

    fun getEquipamento (context: Context, id: Long): Equipamento? {

        if (AndroidUtils.isInternetDisponivel(context)) {
            val url = "$host/api/equipamentos/localizar/${id}"
            val json = HttpHelper.get(url)
            val equipamento = parserJson<Equipamento>(json)
            Log.d(TAG, json)
            return equipamento
        } else {
            val dao = DatabaseManager.getEquipamentoDAO()
            val equipamento = dao.getById(id)
            return equipamento
        }

    }

    fun save(equipamento: Equipamento, context: Context): Response {
        if (AndroidUtils.isInternetDisponivel(context)) {
            val json = HttpHelper.post("$host/api/equipamentos", equipamento.toJson())
            return parserJson(json)
        }
        else {
            saveOffline(equipamento)
            return Response("OK","Equipamento salvo no dispositivo")
        }
    }

    fun saveOffline(equipamento: Equipamento) : Boolean {
        val dao = DatabaseManager.getEquipamentoDAO()

        if (!existeEquipamento(equipamento)) {
            dao.insert(equipamento)
        }
        return true
    }

    fun existeEquipamento(equipamento: Equipamento): Boolean {
        val dao = DatabaseManager.getEquipamentoDAO()
        return dao.getById(equipamento.id) != null
    }

    fun delete(equipamento: Equipamento, context: Context): Response {
        if (AndroidUtils.isInternetDisponivel(context)) {
            val url = "$host/api/equipamentos/remover/${equipamento.numeroEquipamento}"
            val json = HttpHelper.delete(url)
            return parserJson(json)
        } else {
            val dao = DatabaseManager.getEquipamentoDAO()
            dao.delete(equipamento)
            return Response(status = "OK", msg = "Dados salvos localmente")
        }
    }

    private inline fun<reified T> parserJson(json: String) : T{
        val type = object : TypeToken<T>(){}.type
        return Gson().fromJson<T>(json, type)
    }
}