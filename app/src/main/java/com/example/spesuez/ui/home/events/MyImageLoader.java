package com.example.spesuez.ui.home.events;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class MyImageLoader {
    Context context;

    public MyImageLoader(Context context) {
        this.context = context;
    }

    public Bitmap loadImageFromStorage()
    {
        try {
            ContextWrapper cw = new ContextWrapper(context);
            File directory = cw.getDir("imageDir", Context.MODE_PRIVATE);
            File f=new File(directory, "profile.jpg");
            Bitmap b = BitmapFactory.decodeStream(new FileInputStream(f));
            return b;
        }
        catch (FileNotFoundException e)
        {

            return null;
        }
    }

    public void saveToInternalStorage(ImageView imageView){

        Bitmap bitmapImage = ((BitmapDrawable)imageView.getDrawable()).getBitmap();
        ContextWrapper cw = new ContextWrapper(context);
        // path to /data/data/yourapp/app_data/imageDir
        File directory = cw.getDir("imageDir", Context.MODE_PRIVATE);
        // Create imageDir
        File mypath=new File(directory,"profile.jpg");

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(mypath);
            // Use the compress method on the BitMap object to write image to the OutputStream
            bitmapImage.compress(Bitmap.CompressFormat.PNG, 100, fos);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
            }
        }
    }
    public void loadFromUrl(String url,ImageView imageView){
        ImageLoader imageLoader;
        ImageLoaderConfiguration imageLoaderConfiguration=new ImageLoaderConfiguration.Builder(context).build();

        ImageLoader.getInstance().init(imageLoaderConfiguration);
        imageLoader=ImageLoader.getInstance();
        imageLoader .displayImage(url,imageView);
    }
}
