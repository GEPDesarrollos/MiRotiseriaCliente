package com.gep.desarrollos.mirotiseriacliente.modelo;

import android.app.Application;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.iid.FirebaseInstanceId;

/**
 * Created by GEP on 12/10/2017.
 */

public class Rotiseria extends Application{

    private static String tokenRoti;
    private static String tokenApp;
    private static FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
    private static FirebaseInstanceId firebaseInstanceId=FirebaseInstanceId.getInstance();
    private static final String TAG="LaRotiseria";


    @Override
    public void onCreate() {
        super.onCreate();
    }

    public static void leerTokenRotiseria(){

        DatabaseReference refRotiseria = firebaseDatabase.getReference("rotiseria/").child("id");
        refRotiseria.addListenerForSingleValueEvent(new ValueEventListener() {



            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String tokenRotiseria=dataSnapshot.getValue().toString();
                Log.d("leerTokenRoti",tokenRotiseria);
                setTokenRoti(tokenRotiseria);

                           }



            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });

    }



    public static void setTokenRoti(String tokenRoti) {
        Rotiseria.tokenRoti = tokenRoti;
    }



    public static String getTokenRotiseria() {
        return tokenRoti;
    }


    public static String getTokenApp(){

        tokenApp=firebaseInstanceId.getToken();
        Log.d("tokenApp",""+tokenApp);
        return tokenApp;
    }


}
