package com.example.spesuez.Evaluation;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.example.spesuez.Evaluation.helpers.Member;
import com.example.spesuez.Evaluation.helpers.MyImageLoader;
import com.example.spesuez.Evaluation.helpers.MySQLite;
import com.example.spesuez.Evaluation.helpers.MySharedPrefrencesAdapter;
import com.example.spesuez.Evaluation.helpers.Operation;
import com.example.spesuez.Evaluation.helpers.OperationsLoader;
import com.example.spesuez.R;

import java.util.ArrayList;

public class FragC extends Fragment {
    //gui vars
    Button show_operations_button;
    private TextView name;
    private TextView committee;
    private ImageView imageView;
    private Button log_out;
    private SeekBar seekBar;
    private TextView month_text;
    //programming vars
    private View view;
    private Member m;
    public static ArrayList<Operation> my_operations =new ArrayList<>();
    public static ArrayList<Operation> all_operations =new ArrayList<>();
    private MyImageLoader myImageLoader;
    private MySharedPrefrencesAdapter mySharedPrefrencesAdapter;
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragc, container, false);
        // gui defining
        imageView=view.findViewById(R.id.imageView);
        //buttons
        show_operations_button=view.findViewById(R.id.button);
        log_out=view.findViewById(R.id.button2);

        //texts

        name=view.findViewById(R.id.name);
        committee=view.findViewById(R.id.committe);
        seekBar=view.findViewById(R.id.seekBar);
        month_text=view.findViewById(R.id.month);

        // helper vars
        myImageLoader =new MyImageLoader(getContext());
        m=(Member) getArguments().getSerializable("user_member");

        // init code
        name.setText(m.getName());
        committee.setText(m.getCommittee().toString());
        mySharedPrefrencesAdapter=new MySharedPrefrencesAdapter(getActivity());

        //Gender code
        if(m.getGender()== Member.Gender.MALE){
        }else{
            Bitmap  female_icon = BitmapFactory.decodeResource(getContext().getResources(),
                    R.drawable.images);
            imageView.setImageBitmap(female_icon);
        }

        // image code
        if(mySharedPrefrencesAdapter.getState()==true){
            if (!(m.getImg_source().equals(""))&&m.getImg_source()!=null){
                myImageLoader.loadFromUrl(m.getImg_source(),imageView);
            }
        }else {
            Bitmap bitmap = myImageLoader.loadImageFromStorage();
            if (bitmap != null) {
                imageView.setImageBitmap(myImageLoader.loadImageFromStorage());
            }
    }


        //seekbar code
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int seekBarProgress = 1;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBarProgress = progress;

            }

            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                month_text.setText( month_text(seekBarProgress));
            }

        });

        show_operations_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show_operations_button.setOnClickListener(null);
                myImageLoader.saveToInternalStorage(imageView);
                mySharedPrefrencesAdapter.setNonUpdated();
                CounterOfLoading c=new CounterOfLoading(1000,100);
                c.start();
                CountDownTimer c2=new CounterOfNewActivity(5000,1000,getActivity());
                new OperationsLoader(m, c2,view.getContext()).execute();



            }
        });

        log_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               mySharedPrefrencesAdapter.setUpdated();
               MySQLite mySQLite=new MySQLite(getContext());
               mySQLite.dropAll();
               ((MainActivity)getActivity()).replaceByFragB();
            }
        });
        return view;
    }

    private ArrayList<Operation> getByMonth(int month,ArrayList<Operation> my_operations){
        if(month==0)
        {
            month=1;
        }if(month==13){
            month=12;
        }

        Operation.Month mymonth= Operation.Month.valueOf("_"+month);
        ArrayList <Operation> operationArrayList=new ArrayList<Operation>();
        for(Operation p:my_operations){
            if(mymonth.toString().equals(p.getMonth().toString())){
                operationArrayList.add(p);
            }
        }
        return operationArrayList;
    }
    private String month_text(int month){
        if(month==0){
            return "January";
        }else if(month==1){
            return "January";
        }else if (month==2){
            return "February";
        }else if (month==3){
            return "March";
        }else if (month==4){
            return "April";
        }else if (month==5) {
            return "May";
        }else if (month==6) {
            return "June";
        }else if (month==7) {
            return "July";
        }else if (month==8) {
            return "August";
        }else if (month==9) {
            return "September";
        }else if (month==10){
            return "October";
        }else if (month==11) {
            return "November";
        }else {return "December";}
    }
//ٍstarts waiting frag
    private class CounterOfLoading extends CountDownTimer{

        private CounterOfLoading(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {

        }

        @SuppressLint("WrongConstant")
        @Override
        public void onFinish() {
            ((MainActivity)getActivity()).operationsLoaderWait();
        }
    }

    private class CounterOfNewActivity extends CountDownTimer{
    private FragmentActivity fragmentActivity;

        public CounterOfNewActivity(long millisInFuture, long countDownInterval  , FragmentActivity fragmentActivity) {
            super(millisInFuture, countDownInterval);
            this.fragmentActivity=fragmentActivity;
        }

        @Override
        public void onTick(long millisUntilFinished) {
        }

        @Override
        public void onFinish() {
            my_operations=getByMonth(seekBar.getProgress(),my_operations);
            all_operations=getByMonth(seekBar.getProgress(),all_operations);
            new CounterOfNewActivity2(1000,100,fragmentActivity).start();

        }
    }
    private class CounterOfNewActivity2 extends CountDownTimer{
        private FragmentActivity fragmentActivity;

        public CounterOfNewActivity2(long millisInFuture, long countDownInterval , FragmentActivity fragmentActivity) {
            super(millisInFuture, countDownInterval);
            this.fragmentActivity=fragmentActivity;
        }

        @Override
        public void onTick(long millisUntilFinished) {
        }

        @Override
        public void onFinish() {
            Intent intent=new Intent(fragmentActivity,Main2Activity.class);
            intent.putExtra("my_operations",my_operations);
            intent.putExtra("all_operations",all_operations);
            fragmentActivity.startActivity(intent);

        }
    }
}