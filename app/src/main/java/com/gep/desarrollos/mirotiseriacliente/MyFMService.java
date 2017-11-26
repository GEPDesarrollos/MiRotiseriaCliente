package com.gep.desarrollos.mirotiseriacliente;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.gep.desarrollos.mirotiseriacliente.activities.PantallaEspera;
import com.gep.desarrollos.mirotiseriacliente.activities.PantallaPedidoConfirmado;
import com.gep.desarrollos.mirotiseriacliente.activities.PantallaPrincipalActivity;
import com.gep.desarrollos.mirotiseriacliente.modelo.Rotiseria;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import static android.content.ContentValues.TAG;

/**
 * Created by GEP on 10/10/2017.
 */

public class MyFMService extends FirebaseMessagingService {

    MiRotiseriaCliente rotiseria;

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.d(TAG, "From: " + remoteMessage.getFrom());

        // Check if message contains a data payload.
        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "Message data payload: " + remoteMessage.getData());

           /* if (*//* Check if data needs to be processed by long running job *//* true) {
                // For long-running tasks (10 seconds or more) use Firebase Job Dispatcher.
                scheduleJob();
            } else {
                // Handle message within 10 seconds
                handleNow();
            }*/

        }

        // Check if message contains a notification payload.
        if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "Message Notification Body: " + remoteMessage.getData().get("demora"));
        }

        showNotification(remoteMessage.getData().get("demora"),remoteMessage.getData().get("remitente"));
//        showNotification(remoteMessage.getNotification().getTitle(),remoteMessage.getNotification().getBody());
        // Also if you intend on generating your own notifications as a result of a received FCM
        // message, here is where that should be initiated. See sendNotification method below.

    }



    @Override
    public void onMessageSent(String s) {
        super.onMessageSent(s);
    }



    private void showNotification(String title, String text) {

        String titulo = (title == null || title.isEmpty()) ? "Notificación importante" : title;

        Intent notIntent = new Intent(getApplicationContext(), PantallaPedidoConfirmado.class);
        notIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);


        Log.d("Notificacion",title);

        rotiseria=(MiRotiseriaCliente) getApplication();
        rotiseria.setDemora(title);


        PendingIntent contIntent = PendingIntent.getActivity(getApplicationContext(), 0, notIntent, 0);

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setContentIntent(contIntent)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Su pedido estará listo en "+titulo+" min")
                .setContentText(text)
                .setAutoCancel(true);


        notificationBuilder.setContentIntent(contIntent);

        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        notificationBuilder.setSound(alarmSound);


        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(0, notificationBuilder.build());


    }


}
