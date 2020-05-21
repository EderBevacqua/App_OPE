package com.example.andre.monteiro.controlloan

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.io.Serializable

@Entity(tableName = "equipamento")
class Equipamento: Serializable{
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
    var numeroEquipamento: Int  = 0
    var marca = ""
    var modelo =""
    var situacao = ""

    override fun toString() = "id=$id, equipamento=$numeroEquipamento, marca=$marca, modelo=$modelo, situacao=$situacao"

    fun toJson(): String {
        return GsonBuilder().create().toJson(this)
    }
}