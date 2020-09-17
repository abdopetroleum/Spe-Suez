package com.example.spesuez.ui.gallery;

import android.content.Context;
import android.os.AsyncTask;
import android.os.CountDownTimer;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;

public class GaleryLoader extends  AsyncTask<ArrayList<GalleryImage>,ArrayList<GalleryImage>,ArrayList<GalleryImage>> {
    private ArrayList<GalleryImage> my_GalleryImages=new ArrayList<GalleryImage>();
    CountDownTimer c;
    Context a;

    public GaleryLoader(CountDownTimer c, Context a) {
        this.c=c;
        this.a=a;
    }



    @Override
    protected ArrayList<GalleryImage> doInBackground(ArrayList<GalleryImage>... arrayLists) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("galleryImages");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot dataSnapshot) {
                for (DataSnapshot my_data:dataSnapshot.getChildren()) {
                    GalleryImage GalleryImage=my_data.getValue(GalleryImage.class);
                    my_GalleryImages.add(GalleryImage);
                }
                publishProgress(my_GalleryImages);
            }

            @Override
            public void onCancelled( DatabaseError databaseError) {

            }
        });
        return null;
    }
    @Override
    protected void onProgressUpdate(ArrayList<GalleryImage>... values) {
        super.onProgressUpdate(values);
        if (GalleryFragment.galleryImages==null) {
            GalleryFragment.galleryImages = my_GalleryImages;
            c.start();
        }
    }
}

