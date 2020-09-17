package com.example.spesuez.ui.home;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.spesuez.ui.home.TipOfTheDay.TipFrag;
import com.example.spesuez.ui.home.events.EventsFrag;
import com.example.spesuez.ui.home.magazine.MagazineFrag;
import com.example.spesuez.ui.home.main.MainFrag;

public class HomeAdapter extends FragmentPagerAdapter {
    FragmentManager fragmentManager;
    Context context;
    public HomeAdapter(@NonNull FragmentManager fm ,Context context) {
        super(fm);
        this.fragmentManager=fm;
        this.context=context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
       if(position==0){
            return new MainFrag();
        }else if(position==1){
           return new MagazineFrag();
       }else if(position==2) {
           return new EventsFrag();
       }else {
           return new TipFrag();
       }

    }
    @Override
    public CharSequence getPageTitle(int position) {

            if(position==0){
                return "Main";
            }else if(position==1){
                return "Magazines";
            }else if(position==2){
                return "Main Projects";
            }else if(position==3){
                return "Tip of the Day";
            }


        return "main";
    }
    @Override
    public int getCount() {
        return 4;
    }

}
