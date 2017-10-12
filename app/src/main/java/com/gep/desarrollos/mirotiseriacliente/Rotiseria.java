package com.gep.desarrollos.mirotiseriacliente;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by GEP on 12/10/2017.
 */

public class Rotiseria {
    private static String token;
    private static FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();

    public static void leerTokenRotiseria(){
        DatabaseReference refRotiseria = firebaseDatabase.getReference("rotiseria");
        refRotiseria.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String tokenRotiseria=dataSnapshot.child("id").getValue().toString();
                Log.d("leerTokenRoti",tokenRotiseria);
                setToken(tokenRotiseria);
                           }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public static void setToken(String tokenRoti) {
        token = tokenRoti;
    }
    public static String getTokenRotiseria() {
        return token;
    }


}
