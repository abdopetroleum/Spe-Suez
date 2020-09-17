package com.example.spesuez.Evaluation.helpers;

import android.content.Context;
import android.os.AsyncTask;
import android.os.CountDownTimer;

import com.example.spesuez.Evaluation.FragB;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class MemberLoader extends AsyncTask<ArrayList<Member>,ArrayList<Member>,ArrayList<Member>> {
    private ArrayList<Member> my_members=new ArrayList<Member>();
    CountDownTimer c;
    Context a;
    static int number_of_loads=0;

    public MemberLoader(CountDownTimer c,Context a) {
        this.c=c;
        this.a=a;
    }



    @Override
    protected ArrayList<Member> doInBackground(ArrayList<Member>... arrayLists) {
        FileInputStream serviceAccount = null;
        try {
            serviceAccount = new FileInputStream("app/google-servicesmembers.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setApplicationId("1:722449950514:android:ef1d9b400ab4cc14fcd92b")
                .setApiKey("AIzaSyBfok62i6WnsC5jtzFBRLEUbAX4qknFRIY") // Required for Auth.
                .setDatabaseUrl("https://spe-ids.firebaseio.com") // Required for RTDB.
                .build();
        FirebaseApp.initializeApp(a, options, "primary");
        number_of_loads+=1;

    FirebaseApp secondary = FirebaseApp.getInstance("primary");

    FirebaseDatabase secondaryDatabase = FirebaseDatabase.getInstance(secondary);
    DatabaseReference myRef = secondaryDatabase.getReference("ids");

        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot dataSnapshot) {
                for (DataSnapshot my_data:dataSnapshot.getChildren()) {
                    my_members.add(my_data.getValue(Member.class));
                }
                publishProgress(my_members);
            }

            @Override
            public void onCancelled( DatabaseError databaseError) {

            }
        });
        return null;
    }
    @Override
    protected void onProgressUpdate(ArrayList<Member>... values) {
        super.onProgressUpdate(values);
        if(FragB.my_members==null) {
            FragB.my_members = my_members;
            c.start();
        }
}
            }

