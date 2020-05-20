package com.example.andre.monteiro.controlloan

import android.content.SharedPreferences

object Prefs {
    val PREF_ID = "Controlloan"
    private fun prefs(): SharedPreferences {
        val context = ControlloanApplication.getInstance().applicationContext
        return context.getSharedPreferences(PREF_ID, 0)
    }
    fun setString(flag: String, valor: String) = prefs().edit().putString(flag, valor).apply()
    fun getString(valor: String) = prefs().getString(valor,"")
    fun setBoleean(flag: String, valor: Boolean) = prefs().edit().putBoolean(flag, valor).apply()
    fun getBoleean(flag: String) = prefs().getBoolean(flag,false)

}