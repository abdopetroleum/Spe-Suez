package com.example.spesuez.ui.Calculations.TransformationsPackage;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.spesuez.R;

public class TransformationsAdapter extends RecyclerView.Adapter<TransformationsAdapter.MyHolder> {
    private String[] transformation_name ={"Pressure","Length","Temperature","Area","Viscosity",
            "Volume","Density and pressure gradient","Mass and force","Flow rate","Time"};
    private int [] img_ids={R.drawable.pressure,R.drawable.length,R.drawable.temperature,R.drawable.area,R.drawable.viscosity,
            R.drawable.volume
    ,R.drawable.density,R.drawable.mass,R.drawable.flow,R.drawable.time};

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView cardView= (CardView) LayoutInflater.from(parent.getContext()).inflate(
                R.layout.transform_card_view,parent,false);
        return new MyHolder(cardView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, final int position) {
        final CardView cardView=holder.getCardView();
        TextView textView=cardView.findViewById(R.id.transform_info_text);
        textView.setText(transformation_name[position]);
        ImageView imageView=cardView.findViewById(R.id.transform_info_image);
        Glide.with(cardView)
                .load(img_ids[position])
                .into(imageView);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(cardView.getContext(),Transform_Detailed_activity.class);
                intent.putExtra("quantity",transformation_name[position]);
                cardView.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return transformation_name.length;
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        private CardView cardView;
        public MyHolder(@NonNull CardView cardView) {
            super(cardView);
            this.cardView=cardView;
        }

        public CardView getCardView() {
            return cardView;
        }
    }
}
