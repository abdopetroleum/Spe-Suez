package com.example.spesuez.Evaluation.ui.Tasks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.spesuez.Evaluation.Main2Activity;
import com.example.spesuez.R;
import com.example.spesuez.Evaluation.helpers.Drawer;
import com.example.spesuez.Evaluation.helpers.Operation;
import com.example.spesuez.Evaluation.helpers.Operation_Adapter;

public class Tasks extends Fragment implements Drawer {
private ListView listView;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.tasks, container, false);
        listView=root.findViewById(R.id.task_list);
        my_drawer();
        return root;
    }
    @Override
    public void my_drawer() {
        Operation_Adapter operation_adapter=new Operation_Adapter(Main2Activity.my_operations, Operation.Type.TASK,getLayoutInflater());
           listView.setAdapter(operation_adapter);
    }

}