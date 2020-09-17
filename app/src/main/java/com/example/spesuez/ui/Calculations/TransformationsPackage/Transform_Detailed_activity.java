package com.example.spesuez.ui.Calculations.TransformationsPackage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import com.example.spesuez.R;
import com.example.spesuez.ui.Calculations.Transformations;

import java.text.DecimalFormat;

public class Transform_Detailed_activity extends AppCompatActivity {
        private int currentApiVersion;
        private Spinner spinne_inputr;
        private Spinner spinner_output;
        private String s;
        private Transformations transformations;
        private Switch aSwitch;
        private EditText editText;
        private EditText power;

    private AdapterView.OnItemSelectedListener onItemSelectedListener=new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            DecimalFormat decimalFormat=new DecimalFormat("0.###E0");
            TextView textView=findViewById(R.id.text_to_qty);
            try {
                double number=  Double.parseDouble(editText.getText().toString());
                if(power.getText().toString().equals("")){

                }else {
                    number=number*Math.pow(10,Double.parseDouble(power.getText().toString()));
                }
                double d = transformations.get(s,
                        number
                        , spinne_inputr.getSelectedItem().toString(), spinner_output.getSelectedItem().toString());
                if(aSwitch.isChecked()) {
                    textView.setText(decimalFormat.format(d));
                }else {
                    DecimalFormat decimalFormat1=new DecimalFormat("###.###");
                    textView.setText(decimalFormat1.format(d));
                }
            }catch (Exception e){}
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };
    private View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            DecimalFormat decimalFormat=new DecimalFormat("0.###E0");
            TextView textView=findViewById(R.id.text_to_qty);
            try {
                double number=  Double.parseDouble(editText.getText().toString());
                if(power.getText().toString().equals("")){

                }else {
                    number=number*Math.pow(10,Double.parseDouble(power.getText().toString()));
                }
                double d = transformations.get(s,
                        number
                        , spinne_inputr.getSelectedItem().toString(), spinner_output.getSelectedItem().toString());
                if(aSwitch.isChecked()) {
                    textView.setText(decimalFormat.format(d));
                }else {
                    DecimalFormat decimalFormat1=new DecimalFormat("###.###");
                    textView.setText(decimalFormat1.format(d));
                }
            }catch (Exception e){}
        }
    };
    private TextWatcher textWatcher=new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s1, int start, int before, int count) {
            DecimalFormat decimalFormat=new DecimalFormat("0.###E0");
            TextView textView=findViewById(R.id.text_to_qty);
            try {
                double number=  Double.parseDouble(editText.getText().toString());
                if(power.getText().toString().equals("")){

                }else {
                    number=number*Math.pow(10,Double.parseDouble(power.getText().toString()));
                }
                double d = transformations.get(s,
                        number
                        , spinne_inputr.getSelectedItem().toString(), spinner_output.getSelectedItem().toString());
                if(aSwitch.isChecked()) {
                    textView.setText(decimalFormat.format(d));
                }else {
                    DecimalFormat decimalFormat1=new DecimalFormat("###.###");
                    textView.setText(decimalFormat1.format(d));
                }
            }catch (Exception e){}

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
            currentApiVersion = Build.VERSION.SDK_INT;

            final int flags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;

            // This work only for android 4.4+
            if(currentApiVersion >= Build.VERSION_CODES.KITKAT)
            {

                getWindow().getDecorView().setSystemUiVisibility(flags);

                // Code below is to handle presses of Volume up or Volume down.
                // Without this, after pressing volume buttons, the navigation bar will
                // show up and won't hide
                final View decorView = getWindow().getDecorView();
                decorView
                        .setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener()
                        {

                            @Override
                            public void onSystemUiVisibilityChange(int visibility)
                            {
                                if((visibility & View.SYSTEM_UI_FLAG_FULLSCREEN) == 0)
                                {
                                    decorView.setSystemUiVisibility(flags);
                                }
                            }
                        });
            }
            setContentView(R.layout.activity_transform__detailed);

            s = getIntent().getStringExtra("quantity");
        transformations= new Transformations();
        spinne_inputr = findViewById(R.id.spinner_from_unit);
        spinner_output = findViewById(R.id.spinner_to_unit);
        ArrayAdapter arrayAdapter=new ArrayAdapter(this, R.layout.spinner_custom,
                transformations.getUnits(s));
        arrayAdapter.setDropDownViewResource(R.layout.spinner_custom_drop_down);
        spinne_inputr.setAdapter(arrayAdapter);
            ArrayAdapter arrayAdapter2=new ArrayAdapter(this, R.layout.spinner_custom,
                    transformations.getUnits(s));
            arrayAdapter2.setDropDownViewResource(R.layout.spinner_custom_drop_down);
        spinner_output.setAdapter(arrayAdapter2);
        editText = findViewById(R.id.number_text);
         power = findViewById(R.id.power);
         aSwitch = findViewById(R.id.switch_type);
         aSwitch.setOnClickListener(onClickListener);
         spinne_inputr.setOnItemSelectedListener(onItemSelectedListener);
         spinner_output.setOnItemSelectedListener(onItemSelectedListener);
         editText.addTextChangedListener(textWatcher );
         power.addTextChangedListener(textWatcher);


    }



}
