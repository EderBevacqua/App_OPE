package com.example.andre.monteiro.controlloan

import android.content.Intent
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage


class MyFirebaseMessagingService: FirebaseMessagingService() {
    val TAG = "FIREBASE_CONTROLLOAR"
    // recebe o novo token criado
    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.d(TAG, "Novo token: $token")
        // guarda token em SharedPreferences
        Prefs.setString("FB_TOKEN", token!!)
    }

    // recebe a notificação de push
    override fun onMessageReceived(mensagemRemota: RemoteMessage) {
        Log.d(TAG, "onMessageReceived")
        if (mensagemRemota?.notification != null) {
            val titulo = mensagemRemota?.notification?.title
            var corpo = mensagemRemota?.notification?.body
            Log.d(TAG, "Titulo da mensagem: $titulo")
            Log.d(TAG, "Corpo da mensagem: $corpo")

            val intent = Intent(this, EquipamentoActivity::class.java)
            if(mensagemRemota?.data.isNotEmpty()) {
                val equipamentoId = mensagemRemota.data.get("equipamentoId")
                val equipamento = EquipamentoService.getEquipamento(this, equipamentoId!!.toLong())
                intent.putExtra("Equipamento", equipamento)
            }
            NotificationUtil.create(this, 1, intent, titulo!!, corpo!!)
        }
    }

    /*private fun showNotification(mensagemRemota: RemoteMessage) {
        // Intent para abrir quando clicar na notificação
        val intent = Intent(this, EquipamentoActivity::class.java)
        // se título for nulo, utilizar nome no app
        val titulo = mensagemRemota?.notification?.title?: getString(R.string.app_name)
        var mensagem = mensagemRemota?.notification?.body!!

        // verificar se existem dados enviados no push
        if(mensagemRemota?.data.isNotEmpty()) {
            val equipamentoId = mensagemRemota.data.get("equipamentoId")?.toLong()!!
            mensagem += "$mensagem ($equipamentoId)"
            // recuperar equipamento no WS
            val equipamento = EquipamentoService.getEquipamento(this, equipamentoId.toLong())
            intent.putExtra("Equipamento", equipamento)
        }
        NotificationUtil.create(this, 1, intent, titulo, mensagem)
    }*/
}