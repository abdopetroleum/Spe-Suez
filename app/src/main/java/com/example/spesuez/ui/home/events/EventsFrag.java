package com.example.spesuez.ui.home.events;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spesuez.R;

import java.util.ArrayList;

public class EventsFrag extends Fragment {
    public  View view;
    WebView webView;
    public static ArrayList<Event> events;
    public View onCreateView(@NonNull LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.frag_events,container,false);
        webView=view.findViewById(R.id.event_web_view);
        webView.loadUrl("file:///android_asset/event.html");
        CountDownTimer countDownTimer=new Counter(5000,100);
        EventsLoader eventsLoader=new EventsLoader(countDownTimer,getContext());
        eventsLoader.execute();
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
        RecyclerView root = view.findViewById(R.id.event_recycler);
        EventsAdapter magazinesAdapter=new EventsAdapter(events);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        root.setLayoutManager(linearLayoutManager);
        root.setAdapter(magazinesAdapter);
        webView.animate().translationY(-webView.getHeight());
        webView.setVisibility(View.GONE);

    }
}

}
