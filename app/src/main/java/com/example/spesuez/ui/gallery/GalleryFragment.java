package com.example.spesuez.ui.gallery;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spesuez.R;
import com.example.spesuez.ui.home.events.EventsAdapter;
import com.example.spesuez.ui.home.events.EventsFrag;
import com.example.spesuez.ui.home.events.EventsLoader;

import java.util.ArrayList;

public class GalleryFragment extends Fragment {
    public  View view;
    WebView webView;
    public static ArrayList<GalleryImage> galleryImages;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_gallery, container, false);
        webView = view.findViewById(R.id.gallery_web_view);
        webView.loadUrl("file:///android_asset/event.html");
        CountDownTimer countDownTimer = new Counter(3000, 100);
        GaleryLoader  galeryLoader = new GaleryLoader(countDownTimer, getContext());
        galeryLoader.execute();
        return view;

    }
    private class Counter extends CountDownTimer{
            public Counter(long millisInFuture, long countDownInterval) {
                super(millisInFuture, countDownInterval);
            }

            @Override
            public void onTick(long millisUntilFinished) {


    }
            @Override
            public void onFinish() {
                RecyclerView root = view.findViewById(R.id.gallery_recycler);
                webView.animate().translationY(-webView.getHeight());
                webView.setVisibility(View.GONE);
                GaleryAdapter magazinesAdapter=new GaleryAdapter(galleryImages);
                LinearLayoutManager linearLayout=new LinearLayoutManager(getActivity());
                GridLayoutManager gridLayoutManager =new GridLayoutManager(getActivity(),12,
                        GridLayoutManager.VERTICAL,false);
                gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                    @Override
                    public int getSpanSize(int position) {
                    GalleryImage galleryImage=galleryImages.get(position);
                    return galleryImage.getSpan_count();
                    }
                });
                root.setLayoutManager(gridLayoutManager);
                root.setAdapter(magazinesAdapter);


            }
        }

    }