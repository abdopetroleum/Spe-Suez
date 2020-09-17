package com.example.spesuez.ui.Calculations;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spesuez.R;

public class CalculationsFragment extends Fragment {
    public View onCreateView(@NonNull LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.calculations_fragment, container, false);
        RecyclerView root =view.findViewById(R.id.calculation_recycle_view);
        CalculationsAdapter calculationsAdapter=new CalculationsAdapter();
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        GridLayoutManager gridLayoutManager =new GridLayoutManager(getContext(),2,GridLayoutManager.VERTICAL,false);
        root.setLayoutManager(gridLayoutManager);
        root.setAdapter(calculationsAdapter);
        return view;
    }
}