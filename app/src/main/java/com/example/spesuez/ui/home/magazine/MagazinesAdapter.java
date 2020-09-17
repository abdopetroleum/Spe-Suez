package com.example.spesuez.ui.home.magazine;
import android.content.Context;
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

import com.example.spesuez.MyMainActivity;
import com.example.spesuez.R;

public class MagazinesAdapter extends RecyclerView.Adapter<MyHolder> {
    private String[] magazine_name ={"Echo 12","Echo 11","Echo 10","Echo 9","Echo 8",
            "Echo 7","Echo 6","Echo 5",
        "Echo 4","Echo 3","Echo 2","Echo 1"};
    private int [] img_ids={R.drawable.echo13,R.drawable.echo11,R.drawable.echo10
            ,R.drawable.echo9 ,R.drawable.echo8 ,R.drawable.echo7 ,R.drawable.echo6 ,R.drawable.echo5
            ,R.drawable.echo4 ,R.drawable.echo3 ,R.drawable.echo2 ,R.drawable.echo1 };

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView cardView= (CardView) LayoutInflater.from(parent.getContext()).inflate(
                R.layout.magazine_card_view,parent,false);
    return new MyHolder(cardView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, final int position) {
    final CardView cardView=holder.getCardView();
        TextView textView=cardView.findViewById(R.id.info_text);
        textView.setText(magazine_name[position]);
        ImageView imageView=cardView.findViewById(R.id.info_image);
        Drawable drawable =
                ContextCompat.getDrawable(cardView.getContext(), img_ids[position]);
        imageView.setImageDrawable(drawable);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(cardView.getContext(), MagazineActivity.class);
                intent.putExtra("m_name",magazine_name[position]);
                cardView.getContext().startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return magazine_name.length;
    }
}
