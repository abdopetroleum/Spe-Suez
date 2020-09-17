package com.example.spesuez.Evaluation.ui.TotalEvaluation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.spesuez.Evaluation.Main2Activity;
import com.example.spesuez.R;
import com.example.spesuez.Evaluation.helpers.Operation;

import java.util.ArrayList;

public class TotalEvaluation extends Fragment  {
    private float degree;
    private float total_degree;
    private String precentage;
    private TextView text_degree;
    private TextView text_precentage;
    private TextView postion;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.eve, container, false);
        text_degree=root.findViewById(R.id.degree_value);
        text_precentage=root.findViewById(R.id.percentage_value);
        postion=root.findViewById(R.id.postion);
        myCalculator(Main2Activity.my_operations);
        if(semiCalculator(Main2Activity.my_operations)!=0){
        int i=get_position();
            String p;
        if(i==1){
             p ="Congratulations You are the best member for this month";
        }else {
            p=i+"";
        }
        postion.setText(p);
        }else {
            text_degree.setText("");
            text_precentage.setText("");
        }
        return root;
    }
    private  float getTotalDegree(String s){
        String s1=s.substring(s.indexOf("/")+1);
        float a=Float.parseFloat(s1)
                ;
        return a;
    }
    private  float getDegree(String s){
        String s1=s.substring(0, s.indexOf("/"));
        float a=Float.parseFloat(s1)
                ;
        return a;
    }
    private float sumArray(float[]values) {
        float a=0;
        for(float i:values) {
            a=a+i;
        }
        return a;
    }
    private void myCalculator(ArrayList<Operation> operations){
        ArrayList<Operation> array=new ArrayList<Operation>();
        for(Operation operation:operations){
            if(operation.getType()==Operation.Type.MEETING||operation.getType()==Operation.Type.TASK){
                array.add(operation);
            }
        }
        float[] degrees=new float[array.size()];
        float[] total_degrees=new float[array.size()];
        try {
        for(int i=0;i<array.size();i++){
            degrees[i]=getDegree(array.get(i).getValue());
            total_degrees[i]=getTotalDegree(array.get(i).getValue());
        }
         degree=sumArray(degrees);
         total_degree=sumArray(total_degrees);
         precentage=(degree/total_degree*100)+" %";
         text_precentage.setText(precentage);
         text_degree.setText(degree+"/"+total_degree);
    }catch (Exception e){
            Toast.makeText(getContext(), "There is something wrong with your evaluation.\n Please, inform your head.", Toast.LENGTH_LONG).show();
        }
    }

    private float semiCalculator(ArrayList<Operation> operations){
        ArrayList<Operation> array=new ArrayList<Operation>();
        float degree=0;
        for(Operation operation:operations){
            if(operation.getType()==Operation.Type.MEETING||operation.getType()==Operation.Type.TASK){
                array.add(operation);
            }
        }
        float[] degrees=new float[array.size()];
        float[] total_degrees=new float[array.size()];
        try {
        for(int i=0;i<array.size();i++){
            degrees[i]=getDegree(array.get(i).getValue());
        }
        degree=sumArray(degrees);
           }catch (Exception e){

        }
return degree;
    }

    private ArrayList<String> member_ids(ArrayList<Operation> operations){
        ArrayList<String> ids=new ArrayList<String>();
        for(Operation operation:operations){
            if(ids.contains(operation.getMember_id())){}
            else{
                ids.add(operation.getMember_id());
            }
        }

        return ids;
    }

    private ArrayList<ArrayList<Operation>> ordered_operations(ArrayList<Operation> operations,ArrayList<String> member_ids){
        ArrayList<ArrayList<Operation>> ordered_operations=new ArrayList<ArrayList<Operation>>();
      for(String s:member_ids){
          ArrayList<Operation> array=new ArrayList<Operation>();
          for(Operation operation:operations){
              if(operation.getType()==Operation.Type.MEETING||operation.getType()==Operation.Type.TASK){
                  if(operation.getMember_id().equals(s))
                  {array.add(operation);}
              }
          }
          ordered_operations.add(array);
      }

        return ordered_operations;
    }

    private ArrayList<Float> degrees(ArrayList<ArrayList<Operation>> arrayList){
        ArrayList<Float> floats=new ArrayList<Float>();
    for(ArrayList<Operation> operationArrayList:arrayList){
    floats.add(semiCalculator(operationArrayList));
    }

    return floats;
    }

    private int get_position(){
      ArrayList<Float> floats=degrees(ordered_operations(Main2Activity.all_operations,member_ids(Main2Activity.all_operations)));
      int i=1;
      float f= semiCalculator(Main2Activity.my_operations);
      for(Float aFloat :floats){
            if(aFloat>f){
                i++;
            }
      }

      return i;
    }
}