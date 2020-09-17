package com.example.spesuez.Evaluation.helpers;

import android.content.Context;
import android.os.AsyncTask;
import android.os.CountDownTimer;

import com.example.spesuez.Evaluation.FragC;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;

public class OperationsLoader extends AsyncTask<ArrayList <Operation>,ArrayList<Operation>,ArrayList<Operation>> {
     Member my_member;
     CountDownTimer c;
     ArrayList<Operation> all_operations=new ArrayList<Operation>();
    ArrayList<Operation> my_operations=new ArrayList<Operation>();
     Context context;
     static int number_of_loads=0;
      public OperationsLoader(Member my_member,CountDownTimer c, Context context) {
     this.my_member=my_member;
     this.c=c;
     this.context=context;
    }

    private boolean isItsTime(){
       int id=Integer.parseInt(   my_member.getId());
        Calendar rightNow = Calendar.getInstance();
        int currentHourIn24Format = rightNow.get(Calendar.HOUR_OF_DAY);
      if(id%3==currentHourIn24Format%3){
          return true;
      }else {
          return false;
      }
      }
        @Override
    protected ArrayList<Operation> doInBackground(ArrayList<Operation>... arrayLists) {
            if (true) {
                if(number_of_loads==0) {
                    FirebaseOptions options = new FirebaseOptions.Builder()
                            .setApplicationId("1:691618160742:android:535eeb9bac207fac1bcda7") // Required for Analytics.
                            .setApiKey("AIzaSyDR6TrhYpCphUgzLxrx9G6ADYOi8rAI_pk") // Required for Auth.
                            .setDatabaseUrl("https://spe-first-app.firebaseio.com") // Required for RTDB.
                            .build();
                    FirebaseApp.initializeApp(context, options, "secondary");
                    number_of_loads+=1;
                }

                FirebaseApp secondary = FirebaseApp.getInstance("secondary");

                FirebaseDatabase secondaryDatabase = FirebaseDatabase.getInstance(secondary);
                DatabaseReference myRef = secondaryDatabase.getReference("operations");


                myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        for (DataSnapshot my_data : dataSnapshot.getChildren()) {

                                Operation p = my_data.getValue(Operation.class);
                            if (my_member.getCommittee().toString().equals(p.getCommittee().toString())) {
                                all_operations.add(p);
                            }
                            if (my_member.getId().equals(p.getMember_id())) {
                                my_operations.add(p);
                            }

                        }
                        MySQLite mySQLite=new MySQLite(context);
                        mySQLite.dropAll();
                        MySQLite mySQLite1=new MySQLite(context);
                        mySQLite1.insertArray(all_operations);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });}else {
                MySQLite mySQLite=new MySQLite(context);
                all_operations=mySQLite.readData();
            }
            publishProgress(all_operations);
                return null;
           }

    @Override
    protected void onProgressUpdate(ArrayList<Operation>... values) {
        super.onProgressUpdate(values);
        if(FragC.all_operations.size()==0) {
            FragC.all_operations = values[0];
            FragC.my_operations = my_operations;
            c.start();
        }
    }
}


