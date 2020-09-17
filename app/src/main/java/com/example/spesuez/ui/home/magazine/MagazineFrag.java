package com.example.spesuez.ui.home.magazine;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.Fade;
import androidx.transition.Slide;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;

import com.example.spesuez.R;

public class MagazineFrag extends Fragment {
    View parent;
    RecyclerView root;
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_magazine, container, false);
        MagazinesAdapter magazinesAdapter=new MagazinesAdapter();
        GridLayoutManager gridLayoutManager =new GridLayoutManager(getActivity(),2,
        GridLayoutManager.VERTICAL,false);
        parent=view.findViewById(R.id.parent);
         root=view.findViewById(R.id.magazine_recycler);
        root.setLayoutManager(gridLayoutManager);
        root.setAdapter(magazinesAdapter);
        ImageView echo=view.findViewById(R.id.echo);
        ImageView criterion=view.findViewById(R.id.criterion);
        ImageView ultra=view.findViewById(R.id.ultra);
        LinearLayout linearLayout=view.findViewById(R.id.magazine_linear);
        echo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayout.animate()
                        .translationY(-view.getHeight())
                        .alpha(0.0f)
                        .setDuration(800)
                        .setListener(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                super.onAnimationEnd(animation);
                                linearLayout.setVisibility(View.GONE);
                            }
                        });
            }
        });
        ultra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), MagazineActivity.class);
                intent.putExtra("m_name","Ultra 1");
                getContext().startActivity(intent);
            }
        });
        criterion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), MagazineActivity.class);
                intent.putExtra("m_name","Criterion 1");
                getContext().startActivity(intent);
            }
        });
        return view;
    }


}
