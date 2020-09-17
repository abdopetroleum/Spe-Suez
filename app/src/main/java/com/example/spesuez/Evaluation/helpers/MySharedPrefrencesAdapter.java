package com.example.spesuez.Evaluation.helpers;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import java.util.Calendar;

public class MySharedPrefrencesAdapter {
    private Activity activity;

    public MySharedPrefrencesAdapter(Activity activity) {
        this.activity = activity;
        SharedPreferences sharedPreferences=activity.getSharedPreferences("Data", Context.MODE_PRIVATE);
        int month_of_data=sharedPreferences.getInt("month",0);
        Calendar calendar=Calendar.getInstance();
        int month=calendar.get(Calendar.MONTH);
        if(month!=month_of_data){
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.putString("state","updated");
            editor.commit();
        }
    }
    public void setUpdated(){
        SharedPreferences sharedPreferences=activity.getSharedPreferences("Data", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("state","updated");
        editor.commit();

    }
      public void setNonUpdated(){
        SharedPreferences sharedPreferences=activity.getSharedPreferences("Data", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("state","nonupdated");
        editor.commit();

    }

    public boolean getState(){
        SharedPreferences sharedPreferences=activity.getSharedPreferences("Data", Context.MODE_PRIVATE);
        String s=sharedPreferences.getString("state","updated");
        int month_of_data=sharedPreferences.getInt("month",0);
        Calendar calendar=Calendar.getInstance();
        int month=calendar.get(Calendar.MONTH);
        if(s.equals("updated")||month!=month_of_data){
            return true;
        }
        return false;
    }

    public void saveMember(Member user_member){
        SharedPreferences sharedPreferences=activity.getSharedPreferences("Data", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("id",user_member.getId());
        editor.putString("name",user_member.getName());
        editor.putString("img_source",user_member.getImg_source());
        editor.putString("committee",user_member.getCommittee().toString());
        editor.putString("gender",user_member.getGender().toString());
        Calendar calendar=Calendar.getInstance();
        int month=calendar.get(Calendar.MONTH);
        editor.putInt("month",month);
        editor.putString("state","updated");
        editor.commit();
    }

    public Member loadMember(){
        String def="na";
        SharedPreferences sharedPreferences=activity.getSharedPreferences("Data",Context.MODE_PRIVATE);
        Member member=new Member();
        member.setGender(Member.Gender.valueOf(sharedPreferences.getString("gender","MALE")));
        member.setCommittee(Member.Committee.valueOf(sharedPreferences.getString("committee", "ECHO")));
        member.setId(sharedPreferences.getString("id",def));
        member.setName(sharedPreferences.getString("name",def));
        member.setImg_source(sharedPreferences.getString("img_source",def));
        return member;
    }
}
