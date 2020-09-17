package com.example.spesuez.ui.home.events;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Set;

public class EventsSharedPreferencesAdapter {
    private Activity activity;
    private SharedPreferences sharedPreferences;
    public EventsSharedPreferencesAdapter(Activity activity) {
        this.activity = activity;
        sharedPreferences=activity.getSharedPreferences("Data", Context.MODE_PRIVATE);
    }
    private Set<String> loadEvents(){
      Set<String> set=sharedPreferences.getStringSet("events",new HashSet<String>());
      return set;
    }
    public void saveEvent(Event event){
        SharedPreferences.Editor editor=sharedPreferences.edit();
        Set<String> set=loadEvents();
        set.add(event.getName());
        editor.putStringSet("events",set);
        editor.commit();
    }
    public void removeEvent(Event event){
        SharedPreferences.Editor editor=sharedPreferences.edit();
        Set<String> set=loadEvents();
        set.remove(event.getName());
        editor.putStringSet("events",set);
        editor.commit();
    }
    public boolean isExist(Event event){
        Set<String> set=loadEvents();
        if(set.contains(event.getName())){
            return true;
        }else {
            return false;
        }
    }

}
