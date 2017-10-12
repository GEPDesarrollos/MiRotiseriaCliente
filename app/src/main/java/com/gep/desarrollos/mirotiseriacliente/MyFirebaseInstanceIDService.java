package com.gep.desarrollos.mirotiseriacliente;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by GEP on 10/10/2017.
 */

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {
    private String TAG="MyFirebaseInstanceID";
    private String token;

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    @Override
    public void onTokenRefresh() {
        // Get updated InstanceID token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "Refreshed token: " + refreshedToken);


        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.
        setToken(refreshedToken);
        enviarTokenServidor(refreshedToken);


    }

    private void enviarTokenServidor(String refreshedToken) {
        //

    }
}
