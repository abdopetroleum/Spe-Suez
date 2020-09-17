package com.example.spesuez.ui.home.events;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spesuez.MyMainActivity;
import com.example.spesuez.R;
import com.example.spesuez.ui.home.magazine.MagazineActivity;
import com.example.spesuez.ui.home.magazine.MyHolder;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class EventsAdapter extends RecyclerView.Adapter<MyEventHolder> {
    private ArrayList<Event> events;
    public EventsAdapter(ArrayList<Event> events) {
        this.events = events;
    }
    @NonNull
    @Override
    public MyEventHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView cardView= (CardView) LayoutInflater.from(parent.getContext()).inflate(
                R.layout.event_card_view,parent,false);
    return new MyEventHolder(cardView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyEventHolder holder, final int position) {
         final CardView cardView=holder.getCardView();
         MyImageLoader myImageLoader=new MyImageLoader(cardView.getContext());
         ImageView imageView=cardView.findViewById(R.id.event_info_image);
         TextView textView=cardView.findViewById(R.id.event_info_text);
         final Switch aSwitch =cardView.findViewById(R.id.my_event_switch);
         final Event event=events.get(position);
         myImageLoader.loadFromUrl(event.getMain_img(),imageView);
         textView.setText(event.getName());
         final TextView spase=cardView.findViewById(R.id.spape);
         if(events.size()==position+1){
             spase.setVisibility(View.GONE);
         }
         final EventsSharedPreferencesAdapter eventsSharedPreferencesAdapter=new EventsSharedPreferencesAdapter((MyMainActivity)cardView.getContext());
         aSwitch.setChecked(eventsSharedPreferencesAdapter.isExist(event));
            aSwitch.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EventNotificationHelper eventNotificationHelper=new EventNotificationHelper(cardView.getContext());
                    if(aSwitch.isChecked()){
                       eventsSharedPreferencesAdapter.saveEvent(event);
                        Calendar calendar=new GregorianCalendar();
                        int year=calendar.get(Calendar.YEAR);
                        int month=calendar.get(Calendar.MONTH);
                        int day=calendar.get(Calendar.DAY_OF_MONTH);
                        if(year<event.getYear()||(event.getYear()==year&&event.getMonth()>month)
                        ||(year==event.getYear()&&month==event.getMonth()&&event.getDay()>=day)){
                       eventNotificationHelper.addAlarmForEvent(events.get(position));
                        }
                    }else {
                        eventsSharedPreferencesAdapter.removeEvent(events.get(position));
                        eventNotificationHelper.removeAlarmForEvent(events.get(position));
                    }
                }
            });
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(cardView.getContext(),EventDetailsActivity.class);
                    Bundle bundle=new Bundle();
                    bundle.putSerializable("event",events.get(position));
                    intent.putExtra("m2",bundle);
                    cardView.getContext().startActivity(intent);
                }
            });
    }
    @Override
    public int getItemCount() {
        return events.size();
    }
}
