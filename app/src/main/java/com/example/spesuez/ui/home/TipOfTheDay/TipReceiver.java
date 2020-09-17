package com.example.spesuez.ui.home.TipOfTheDay;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.spesuez.Evaluation.MainActivity;

public class TipReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        TipLoader tipLoader=new TipLoader(true,context);
        tipLoader.execute();

    }
}
