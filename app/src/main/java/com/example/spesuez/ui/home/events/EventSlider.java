package com.example.spesuez.ui.home.events;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.spesuez.R;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.Calendar;

public class EventSlider extends SliderViewAdapter<EventSlider.SliderAdapterVH> {
    private Event event;
    private Context context;
    public EventSlider(Event event, Context context) {
        this.event = event;
        this.context = context;
    }


    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_slider_layout_item, null);
        return new SliderAdapterVH(inflate);
    }

    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder, int position) {


                Glide.with(viewHolder.itemView)
                        .load(event.getImg_map().get("_"+position))
                        .into(viewHolder.imageViewBackground);



    }

    @Override
    public int getCount() {
        //slider view count could be dynamic size
        return event.getImg_map().size();
    }

    class SliderAdapterVH extends SliderViewAdapter.ViewHolder {

        View itemView;
        ImageView imageViewBackground;

        public SliderAdapterVH(View itemView) {
            super(itemView);
            imageViewBackground = itemView.findViewById(R.id.iv_auto_image_slider);

            this.itemView = itemView;
        }
    }
}
