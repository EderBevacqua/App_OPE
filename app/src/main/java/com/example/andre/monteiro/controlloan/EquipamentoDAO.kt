package com.example.andre.monteiro.controlloan

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface EquipamentoDAO {
    @Query("SELECT * FROM equipamento where id = :id")
    fun getById(id: Long) : Equipamento?

    @Query("SELECT * FROM equipamento")
    fun findAll(): List<Equipamento>

    @Insert
    fun insert(equipamento: Equipamento)

    @Delete
    fun delete(equipamento: Equipamento)

}