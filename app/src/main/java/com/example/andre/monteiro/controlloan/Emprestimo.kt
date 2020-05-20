package com.example.andre.monteiro.controlloan

import java.io.Serializable

class Emprestimo: Serializable {
    var id: Long = 0
    var id_usuario = ""
    var nome = ""
    var numeroMatricula = ""
    var departamento = ""
    var email = ""
    var telefone = ""
    var dtSolicitacao = ""
    var dtEmprestimo = ""
    var dtDevolucao = ""
    var status = ""

    override fun toString() = "id=$id, id_usuario=$id_usuario, nome=$nome, numeroMatricula=$numeroMatricula, departamento=$departamento, email=$email, telefone=$telefone, dtSolicitacao=$dtSolicitacao, dtEmprestimo$dtEmprestimo,dtDevolucao=$dtDevolucao, status=$status"
}