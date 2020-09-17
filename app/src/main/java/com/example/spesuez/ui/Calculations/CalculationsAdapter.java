package com.example.spesuez.ui.Calculations;

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

import com.example.spesuez.R;
import com.example.spesuez.ui.Calculations.Flow.Flow_equations;
import com.example.spesuez.ui.Calculations.TransformationsPackage.Transformations_Activity;

public class CalculationsAdapter extends RecyclerView.Adapter<CalculationsAdapter.MyHolder> {
    private String[] calculation_name ={"Unit converter","Flow Equations"};
    private int [] img_ids={R.drawable.calcu,R.drawable.flw};
    private Class[] aClass={Transformations_Activity.class, Flow_equations.class};
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
        TextView textView=cardView.findViewById(R.id.transform_info_text );
        textView.setText(calculation_name[position]);
        ImageView imageView=cardView.findViewById(R.id.transform_info_image);
        Drawable drawable =
                ContextCompat.getDrawable(cardView.getContext(), img_ids[position]);
        imageView.setImageDrawable(drawable);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(cardView.getContext(),aClass[position]);
                cardView.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return calculation_name.length;
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
