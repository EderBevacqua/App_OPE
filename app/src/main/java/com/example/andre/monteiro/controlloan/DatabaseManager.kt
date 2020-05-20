package com.example.andre.monteiro.controlloan

import androidx.room.Room

object DatabaseManager {

    // singleton
    private var dbInstance: ControlloanDataBase
    init {
        val appContext = ControlloanApplication.getInstance().applicationContext
        dbInstance = Room.databaseBuilder(
            appContext, // contexto global
            ControlloanDataBase::class.java, // Referência da classe do banco
            "Controlloan.sqlite" // nome do arquivo do banco
        ).build()
    }

    fun getEquipamentoDAO(): EquipamentoDAO {
        return dbInstance.equipamentoDAO()
    }
}