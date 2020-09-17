package com.example.spesuez.ui.home.TipOfTheDay;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;

import com.example.spesuez.MyMainActivity;
import com.example.spesuez.R;

public class TipNotification {
    public TipNotification(TipofTheDay tipofTheDay ,Context context ){
        NotificationManager notificationManager= (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel=new NotificationChannel("tips","Tip of the day"
                    ,NotificationManager.IMPORTANCE_HIGH);
            notificationManager.createNotificationChannel(notificationChannel);
        }
        Intent intent=new Intent(context, MyMainActivity.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(context,0,intent,0);
        NotificationCompat.Builder builder=new NotificationCompat.Builder(context,"tips")
                .setContentTitle(tipofTheDay.getName())
                .setContentText(tipofTheDay.getContent())
                .setSmallIcon(R.drawable.spe)
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText(tipofTheDay.getContent()))
                .setContentIntent(pendingIntent)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setDefaults(NotificationCompat.DEFAULT_SOUND )
                .setAutoCancel(true);


        notificationManager.notify(2,builder.build());
    }
}
