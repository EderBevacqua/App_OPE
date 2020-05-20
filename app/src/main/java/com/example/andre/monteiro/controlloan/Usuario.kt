package com.example.andre.monteiro.controlloan

import java.io.Serializable

class Usuario: Serializable{
    var id:Long=0
    var id_usuario=""
    var nome=""
    var numeroMatricula=""
    var email=""
    var departamento=""
    var telefone=""
    var contaAtiva=""
    var isAdmin=""
    var senha=""
    var ultimoAcesso=""

    override fun toString() =  "id=$id, id_usuario=$id_usuario, nome=$nome, numeroMatricula=$numeroMatricula email=$email, departamento=$departamento, telefone=$telefone, contaAtiva=$contaAtiva, isAdmin=$isAdmin, senha=$senha, ultimoAcesso=$ultimoAcesso"

}