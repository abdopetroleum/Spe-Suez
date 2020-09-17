package com.example.spesuez.Evaluation.helpers;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.spesuez.R;

import java.util.ArrayList;

public class Operation_Adapter extends BaseAdapter {
    private ArrayList<Operation> my_operations=new ArrayList<Operation>();
    LayoutInflater inflater;
    private Operation.Type type;
    private ArrayList<Operation> custom_operations=new ArrayList<Operation>();
    public Operation_Adapter(ArrayList<Operation> my_operations, Operation.Type type, LayoutInflater inflater) {
        this.type=type;
        this.inflater=inflater;
        this.my_operations = my_operations;
    for(Operation operation:my_operations){
        if(operation.getType()==type){
            custom_operations.add(operation);
        }
    }
    }


    @Override
    public int getCount() { return custom_operations.size();
    }

    @Override
    public Object getItem(int position) {
        return custom_operations.get(position).toString();
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view1= inflater.inflate(R.layout.operation_item, null);
        if(type==Operation.Type.POSITIVE_NOTE||type==Operation.Type.NEGATIVE_NOTE){
             view1= inflater.inflate(R.layout.operation_item2, null);
        }
        TextView textView_name=view1.findViewById(R.id.textView_name);
        TextView textView_value=view1.findViewById(R.id.textView_value);
        textView_name.setText(custom_operations.get(position).getName());
        textView_value.setText(custom_operations.get(position).getValue());
        return view1;
    }
}
