package com.example.spesuez.ui.home.TipOfTheDay;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.spesuez.R;
import com.example.spesuez.ui.home.events.EventAlertReceiver;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class TipFrag extends Fragment {
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.tip_frag,container,false);
        TipSharedPrefrencesAdapter tipSharedPrefrencesAdapter=new TipSharedPrefrencesAdapter(getActivity());
        TipofTheDay tipofTheDay=tipSharedPrefrencesAdapter.loadTip();
        SliderView sliderView =view. findViewById(R.id.tip_image_slider);
        if(tipofTheDay.getImages_map().size()!=0){
        TipSlider tipSlider=new TipSlider(tipofTheDay,getContext());
        sliderView.setSliderAdapter(tipSlider);
        }else {
            sliderView.setVisibility(View.GONE);
        }
        TextView name=view.findViewById(R.id.event_name);
        name.setText(tipofTheDay.getName());
        TextView content=view.findViewById(R.id.tip_content);
        content.setText(tipofTheDay.getContent());
        TipLoader tipLoader=new TipLoader(getActivity(),false,getContext());
        tipLoader.execute();
        sliderView.setIndicatorAnimation(IndicatorAnimations.WORM); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(15); //set scroll delay in seconds :
        sliderView.startAutoCycle();
        updateTipwithNNotification();
        return view;
    }
    private void updateTipwithNNotification(){
        Calendar calendar=new GregorianCalendar();
        long l;
        if (calendar.get(Calendar.HOUR_OF_DAY)>=19){
            calendar.set(Calendar.HOUR_OF_DAY,19);
            calendar.set(Calendar.MINUTE,0);
            calendar.set(Calendar.SECOND,0);
            l=calendar.getTimeInMillis()+24*60*60*1000;
        }else {
            calendar.set(Calendar.HOUR_OF_DAY,19);
            calendar.set(Calendar.MINUTE,0);
            calendar.set(Calendar.SECOND,0);
            l=calendar.getTimeInMillis();
        }

        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        Intent intent=new Intent(getContext(), TipReceiver.class);
        AlarmManager alarmManager= (AlarmManager) getContext().getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP,l, PendingIntent.getBroadcast(getContext(),
                0,
                intent,PendingIntent.FLAG_UPDATE_CURRENT));
    }

}
