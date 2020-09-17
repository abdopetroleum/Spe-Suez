package com.example.spesuez.ui.home.TipOfTheDay;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.spesuez.ui.home.events.Event;

import java.util.HashSet;
import java.util.Set;

public class TipSharedPrefrencesAdapter {
    private Activity activity;
    private SharedPreferences sharedPreferences;
    public TipSharedPrefrencesAdapter(Activity activity) {
        this.activity = activity;
        sharedPreferences=activity.getSharedPreferences("Tip", Context.MODE_PRIVATE);
    }
    public TipofTheDay loadTip(){
      Set<String> set=sharedPreferences.getStringSet("images",new HashSet<String>());
      String name=sharedPreferences.getString("name","Oil Formation Volume factor");
      String content =sharedPreferences.getString("content","The ratio between the volume of oil under reservoir conditions to its volume under standard conditions and it is always greater than 1");
      TipofTheDay tipofTheDay=new TipofTheDay(name,content,set);
      return tipofTheDay;
    }
    public void saveTip(TipofTheDay tipofTheDay){
        SharedPreferences.Editor editor=sharedPreferences.edit();
        if(tipofTheDay.getImages_map()==null){
            editor.putStringSet("images",new HashSet<String>());
        }else {
            editor.putStringSet("images", new HashSet<>(tipofTheDay.getImages_map().values()));
        }
        editor.putString("name",tipofTheDay.getName());
        editor.putString("content",tipofTheDay.getContent());
        editor.commit();
    }
}
