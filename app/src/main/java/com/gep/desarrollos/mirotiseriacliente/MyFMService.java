package com.gep.desarrollos.mirotiseriacliente;

import android.app.Service;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by GEP on 10/10/2017.
 */

public class MyFMService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
    }

    @Override
    public void onMessageSent(String s) {
        super.onMessageSent(s);
    }
}
