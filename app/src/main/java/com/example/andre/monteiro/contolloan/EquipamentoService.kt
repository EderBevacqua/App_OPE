package com.example.andre.monteiro.controlloan

import android.content.Context

object EquipamentoService {
    fun getEquipamentos(context: Context): List<Equipamento>{
        val equipamentos = mutableListOf<Equipamento>()
        for (i in 1..1) {
            val e1 = Equipamento()
            e1.Equipamento = "Notebook"
            e1.modelo = "Modelo $i"
            e1.marca = "marca $i"
            e1.foto = "https://img.clasf.com.br/2018/01/16/Ultra-book-ASUS-i5-aceito-troca-20180116132921.jpg"
            equipamentos.add(e1)

            val e2 = Equipamento()
            e2.Equipamento = "Ipad"
            e2.modelo = "5 $i"
            e2.marca = "Apple $i"
            e2.foto = "https://i.zst.com.br/images/tablet-apple-ipad-pro-3-geracao-apple-a12x-bionic-256gb-liquid-retina-11-ios-12-12-mp-photo925954245-12-3f-18.jpg"
            equipamentos.add(e2)

            val e3 = Equipamento()
            e3.Equipamento = "Chromebook"
            e3.modelo = "Plus $i"
            e3.marca = "Samsung $i"
            e3.foto = "https://i.zst.com.br/images/notebook-lenovo-ideapad-330-intel-core-i3-7020u-7-geracao-4gb-de-ram-hd-1-tb-15-6-windows-10-ideapad-330-photo565033713-45-23-30.jpg"
            equipamentos.add(e3)
        }
        return equipamentos
    }
}