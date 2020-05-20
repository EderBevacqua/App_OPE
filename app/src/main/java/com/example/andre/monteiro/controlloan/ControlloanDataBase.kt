package com.example.andre.monteiro.controlloan

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Equipamento::class), version = 1)
abstract class ControlloanDataBase: RoomDatabase() {
    abstract fun equipamentoDAO() : EquipamentoDAO

}