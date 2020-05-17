package com.example.andre.monteiro.controlloan

import java.io.Serializable

class Equipamento : Serializable {
    val id: Long = 0
    var Equipamento: String = "Notebook"
    var modelo: String = "Inspiron"
    var marca: String = "Dell"
    var foto: String = "@+drawable/dell_inspiron"

    override fun toString(): String {
        return "Equipamento (Tipo= '$Equipamento', modelo = '$modelo', marca = '$marca')"
    }
}

