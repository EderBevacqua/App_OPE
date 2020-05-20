package com.example.andre.monteiro.controlloan

import java.io.Serializable

class SolicitarEmprestimo: Serializable {
    var id = ""
    var id_emprestimo = ""
    var id_equipamento = ""
    var id_usuario = ""
    var dtSolicitacao = ""
    var dtEmprestimo = ""
    var dtDevolucao = ""
    var status = ""
    var nome = ""
    var numeroMatricula = ""
    var departamento = ""
    var email = ""
    var telefone = ""
    var numeroEquipamento = ""
    var marca = ""
    var modelo = ""
    var situacao = ""

    override fun toString() = "id=$id, id_emprestimo=$id_emprestimo, id_equipamento=$id_equipamento, id_usuario=$id_usuario, dtSolicitacao=$dtSolicitacao, dtEmprestimo=$dtEmprestimo, dtDevolucao=$dtDevolucao, status=$status, nome=$nome, numeroMatricula=$numeroMatricula, departamento=$departamento, email=$email, telefone=$telefone, numeroEquipamento=$numeroEquipamento, marca=$marca, modelo=$modelo, situacao=$situacao"
}