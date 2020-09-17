package com.example.spesuez.ui.home.TipOfTheDay;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.spesuez.R;
import com.smarteist.autoimageslider.SliderViewAdapter;
public class TipSlider extends SliderViewAdapter<TipSlider.SliderAdapterVH>{
    private TipofTheDay tipofTheDay;
    private Context context;
    public TipSlider(TipofTheDay tipofTheDay, Context context) {
        this.tipofTheDay = tipofTheDay;
        this.context = context;
    }


    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.tip_image_slider_layout_item, null);
        return new SliderAdapterVH(inflate);
    }

    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder, int position) {
        Glide.with(viewHolder.itemView)
                .load(tipofTheDay.getImages_map().get("_"+position))
                .into(viewHolder.imageViewBackground);
    }

    @Override
    public int getCount() {
        //slider view count could be dynamic size
        return tipofTheDay.getImages_map().size();
    }

    class SliderAdapterVH extends SliderViewAdapter.ViewHolder {

        View itemView;
        ImageView imageViewBackground;
        TextView textViewDescription;

        public SliderAdapterVH(View itemView) {
            super(itemView);
            imageViewBackground = itemView.findViewById(R.id.aa);
            textViewDescription = itemView.findViewById(R.id.tv);
            this.itemView = itemView;
        }
    }
}
