package com.example.spesuez.ui.home.events;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class EventNotificationHelper {
    private Context context;

    public EventNotificationHelper(Context context) {
        this.context = context;
    }

    public void addAlarmForEvent(Event event){
        Calendar calendar=new GregorianCalendar();
        calendar.set(event.getYear(),event.getMonth(),event.getDay(),event.getHour(),event.getMinute(),event.getSecond());
        Intent intent=new Intent(context,EventAlertReceiver.class);
        Bundle bundle=new Bundle();
        bundle.putSerializable("event",event);
        intent.putExtra("m",bundle);
        AlarmManager alarmManager= (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(), PendingIntent.getBroadcast(context,
                Integer.parseInt(event.getDay()+""+event.getMonth()),
                intent,PendingIntent.FLAG_UPDATE_CURRENT));
    }
    public void removeAlarmForEvent(Event event){
        Intent intent=new Intent(context,EventAlertReceiver.class);
        intent.putExtra("event",event);
        AlarmManager alarmManager= (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
       alarmManager.cancel( PendingIntent.getBroadcast(context,
               Integer.parseInt(event.getDay()+""+event.getMonth()),
               intent,PendingIntent.FLAG_UPDATE_CURRENT));
    }

}
