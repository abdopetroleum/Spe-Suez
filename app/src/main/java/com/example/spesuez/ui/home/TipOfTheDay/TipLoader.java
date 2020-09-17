package com.example.spesuez.ui.home.TipOfTheDay;
import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.CountDownTimer;
import android.widget.Toast;

import com.example.spesuez.ui.home.events.Event;
import com.example.spesuez.ui.home.events.EventsFrag;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
public class TipLoader extends  AsyncTask<TipofTheDay,TipofTheDay,TipofTheDay> {
    private Activity activity;
    private  boolean withNotifcation;
    private Context context;
    public TipLoader(Activity activity,Boolean withNotifcation,Context context) {
        this.activity = activity;
        this.withNotifcation=withNotifcation;
        this.context=context;
    }

    public TipLoader(boolean withNotifcation, Context context) {
        this.withNotifcation = withNotifcation;
        this.context = context;
    }

    @Override
    protected TipofTheDay doInBackground(TipofTheDay... arrayLists) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("tip");


        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot dataSnapshot) {
                for (DataSnapshot my_data:dataSnapshot.getChildren()) {
                    TipofTheDay tipofTheDay=my_data.getValue(TipofTheDay.class);
                    publishProgress(tipofTheDay);
                }
            }

            @Override
            public void onCancelled( DatabaseError databaseError) {

            }
        });
        return null;
    }
    @Override
    protected void onProgressUpdate(TipofTheDay... values) {
        super.onProgressUpdate(values);
        TipofTheDay tipofTheDay=values[0];
        if(activity!=null) {
            TipSharedPrefrencesAdapter tipSharedPrefrencesAdapter = new TipSharedPrefrencesAdapter(activity);
            tipSharedPrefrencesAdapter.saveTip(tipofTheDay);
        }
        if(withNotifcation){
            TipNotification tipNotification=new TipNotification(tipofTheDay,context);
        }
    }
}

