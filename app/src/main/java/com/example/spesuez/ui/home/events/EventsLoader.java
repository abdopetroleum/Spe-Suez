package com.example.spesuez.ui.home.events;

import android.content.Context;
import android.os.AsyncTask;
import android.os.CountDownTimer;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class EventsLoader extends  AsyncTask<ArrayList<Event>,ArrayList<Event>,ArrayList<Event>> {
    private ArrayList<Event> my_Events=new ArrayList<Event>();
    CountDownTimer c;
    Context a;

    public EventsLoader(CountDownTimer c,Context a) {
        this.c=c;
        this.a=a;
    }



    @Override
    protected ArrayList<Event> doInBackground(ArrayList<Event>... arrayLists) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("events");


        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot dataSnapshot) {
                for (DataSnapshot my_data:dataSnapshot.getChildren()) {
                    Event event=my_data.getValue(Event.class);
                    event.split();
                    my_Events.add(event);
                }
                publishProgress(my_Events);
            }

            @Override
            public void onCancelled( DatabaseError databaseError) {

            }
        });
        return null;
    }
    @Override
    protected void onProgressUpdate(ArrayList<Event>... values) {
        super.onProgressUpdate(values);
        if(EventsFrag.events==null) {
            c.start();
            EventsFrag.events = my_Events;
        }
    }
}

