package com.example.spesuez.ui.gallery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.spesuez.R;
import com.example.spesuez.ui.home.events.Event;
import com.github.chrisbanes.photoview.PhotoView;
import com.github.chrisbanes.photoview.PhotoViewAttacher;

public class GalleryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        Bundle bundle=getIntent().getBundleExtra("m2");
        GalleryImage galleryImage=(GalleryImage) bundle.getSerializable("image");
        TextView name=findViewById(R.id.gallery_name);
        TextView info=findViewById(R.id.gallery_info);

        PhotoView photoView = (PhotoView) findViewById(R.id.photo_view);
        //  TextView info=cardView.findViewById(R.id.image_info);
        if(galleryImage.getUrl()!=null) {
            Glide.with(photoView)
                    .load(galleryImage.getUrl())
                    .placeholder(R.drawable.spe)
                    .override(1500,1000)
                    .fitCenter()
                    .into(photoView);
        }
        PhotoViewAttacher photoViewAttacher=new PhotoViewAttacher(photoView);
        photoViewAttacher.update();
        int i=0;
        if (galleryImage.getInfo()!=null){
            info.setText(galleryImage.getInfo());
        }else {
            info.setVisibility(View.GONE);
                    }
        if (galleryImage.getName()!=null){
            name.setText(galleryImage.getName());
        }else {
            name.setVisibility(View.GONE);
        }

    }
}
