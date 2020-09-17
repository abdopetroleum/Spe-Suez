package com.example.spesuez.ui.home;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.ShareActionProvider;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.spesuez.R;
import com.example.spesuez.ui.home.events.EventsAdapter;
import com.example.spesuez.ui.home.events.EventsFrag;
import com.example.spesuez.ui.home.events.EventsLoader;
import com.google.android.material.tabs.TabLayout;
public class HomeFragment extends Fragment {
    private ShareActionProvider shareActionProvider;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             final ViewGroup container, Bundle savedInstanceState) {
         View root = inflater.inflate(R.layout.fragment_home, container, false);
            ViewPager pager = (ViewPager) root.findViewById(R.id.pager);
        pager.removeAllViews();
        pager.setAdapter(null);
            HomeAdapter pagerAdapter =new HomeAdapter(getFragmentManager(),getContext());
            pager.setAdapter(pagerAdapter);

        final TabLayout tabLayout = (TabLayout) root.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(pager);
              return root;
    }
}