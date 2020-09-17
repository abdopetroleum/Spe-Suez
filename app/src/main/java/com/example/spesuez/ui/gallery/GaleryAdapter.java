package com.example.spesuez.ui.gallery;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.spesuez.R;
import com.example.spesuez.ui.home.events.EventDetailsActivity;
import com.example.spesuez.ui.home.events.MyEventHolder;
import com.github.chrisbanes.photoview.PhotoViewAttacher;

import java.util.ArrayList;

public class GaleryAdapter extends RecyclerView.Adapter<MyEventHolder> {
    private ArrayList<GalleryImage> galleryImages;
    public GaleryAdapter(ArrayList<GalleryImage> galleryImages) {
        this.galleryImages = galleryImages;
    }
    @Override
    public MyEventHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView cardView= (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.gallery_card_view,parent,false);
    return new MyEventHolder(cardView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyEventHolder holder, final int position) {
         final CardView cardView=holder.getCardView();
        ImageView imageView=cardView.findViewById(R.id.gallery_image);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(cardView.getContext(), GalleryActivity.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable("image",galleryImages.get(position));
                intent.putExtra("m2",bundle);
                cardView.getContext().startActivity(intent);
            }
        });
     //   TextView name=cardView.findViewById(R.id.image_name);
      //  TextView info=cardView.findViewById(R.id.image_info);
        GalleryImage galleryImage = galleryImages.get(position);
        if(galleryImage.getUrl()!=null) {
            Glide.with(cardView)
                    .load(galleryImage.getUrl())
                    .placeholder(R.drawable.spe)
                    .override(1500,1000)
                    .fitCenter()
                    .into(imageView);
        }
        /*int i=0;
        if (galleryImage.getInfo()!=null){
            info.setText(galleryImage.getInfo());
        }else {
            info.setVisibility(View.GONE);
            i++;
        }
        if (galleryImage.getName()!=null){
            name.setText(galleryImage.getName());
        }else {
            name.setVisibility(View.GONE);
            i++;
        }
        if(i==2){
            LinearLayout linearLayout=cardView.findViewById(R.id.info_container);
            linearLayout.setVisibility(View.GONE);
        }*/


    }
    @Override
    public int getItemCount() {
        return galleryImages.size();
    }

}
