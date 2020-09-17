package com.example.spesuez.ui.home.events;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;

import com.example.spesuez.R;

public class EventAlertReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle=intent.getBundleExtra("m");
        Event event=(Event) bundle.getSerializable("event");
        createNotification(context,event.getName(),event.getContent());

    }
    public void createNotification(Context context,String name ,String content){
       /* PendingIntent pendingIntent= PendingIntent.getActivity(context,0,
                new Intent(context,MoreInfoNotification.class),0);
        */
       NotificationManager notificationManager= (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel=new NotificationChannel("events","Events"
                    ,NotificationManager.IMPORTANCE_HIGH);
            notificationManager.createNotificationChannel(notificationChannel);
        }
        NotificationCompat.Builder builder=new NotificationCompat.Builder(context,"events")
                .setContentTitle(name)
                .setContentText("We remind you with our event "+name)
                .setSmallIcon(R.drawable.spe)
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText(content))
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setDefaults(NotificationCompat.DEFAULT_SOUND )
                .setAutoCancel(true);


        notificationManager.notify(1,builder.build());
    }
}
