package com.example.spesuez.ui.Calculations.Flow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;

import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.spesuez.R;
import com.example.spesuez.ui.Calculations.Transformations;

import java.text.DecimalFormat;

public class Flow_equations extends AppCompatActivity {
    private int currentApiVersion;
    private DecimalFormat decimalFormat=new DecimalFormat("###.###");
    private double p1;
    private double p2;
    private double r2;
    private double r1;
    private double l;
    private double h;
    private double k;
    private double area;
    private double v;
    private double z=1;
    //additional
    private double ps=1;
    private Transformations.PressureUnit ps_unit=Transformations.PressureUnit.atm;
    private double tf=60;
    private Transformations.TemperatureUnit tf_temperatureUnit=Transformations.TemperatureUnit.F;
    private double ts=60;
    private Transformations.TemperatureUnit ts_temperatureUnit2 =Transformations.TemperatureUnit.F;
    private double B=1;
    private FlowEquations flowEquations=new FlowEquations();
    private Transformations transformations=new Transformations();


    //gui vars
    private Switch aSwitch;
    private Switch aSwitch2;

    private LinearLayout p2_linearLayout;
    private TextView p2_text;
    private Spinner p2_spinner;
    private EditText p2_input;

    private LinearLayout p1_linearLayout;
    private TextView p1_text;
    private Spinner p1_spinner;
    private EditText p1_input;

    private LinearLayout ps_linearLayout;
    private TextView ps_text;
    private Spinner ps_spinner;
    private EditText ps_input;

    private LinearLayout r2_linearLayout;
    private TextView r2_text;
    private Spinner r2_spinner;
    private EditText r2_input;

    private LinearLayout r1_linearLayout;
    private TextView r1_text;
    private Spinner r1_spinner;
    private EditText r1_input;

    private LinearLayout l_linearLayout;
    private TextView l_text;
    private Spinner l_spinner;
    private EditText l_input;

    private LinearLayout h_linearLayout;
    private TextView h_text;
    private Spinner h_spinner;
    private EditText h_input;

    private LinearLayout area_linearLayout;
    private TextView area_text;
    private Spinner area_spinner;
    private EditText area_input;

    private LinearLayout k_linearLayout;
    private TextView k_text;
    private Spinner k_spinner;
    private EditText k_input;

    private LinearLayout v_linearLayout;
    private TextView v_text;
    private Spinner v_spinner;
    private EditText v_input;

    private LinearLayout tf_linearLayout;
    private TextView tf_text;
    private Spinner tf_spinner;
    private EditText tf_input;

    private LinearLayout ts_linearLayout;
    private TextView ts_text;
    private Spinner ts_spinner;
    private EditText ts_input;

    private LinearLayout z_linearLayout;
    private EditText z_input;

    private LinearLayout b_linearLayout;
    private TextView b_text;
    private Spinner b_spinner;
    private EditText b_input;

    private Spinner flow_type;
    private LinearLayout switchLinearLayout;

    private Button button;
    //gui results
    private Spinner flow_spinner;
    private LinearLayout q1_linearLayout;
    private TextView q1TextView;

    private LinearLayout q2_linearLayout;
    private TextView q2TextView;

    private LinearLayout q3_linearLayout;
    private TextView q3TextView;

    public double perform(int i){
        p1=Double.parseDouble(p1_input.getText().toString());
        p2=Double.parseDouble(p2_input.getText().toString());
        k=Double.parseDouble(k_input.getText().toString());
        v=Double.parseDouble(v_input.getText().toString());
        if(i>3){
        h=Double.parseDouble(h_input.getText().toString());
        r1=Double.parseDouble(r1_input.getText().toString());
        r2=Double.parseDouble(r2_input.getText().toString());
        }else {
            l = Double.parseDouble(l_input.getText().toString());
            area = Double.parseDouble(area_input.getText().toString());
        }
        if(i==0){
           return flowEquations.getFlowRate(0,p1, Transformations.PressureUnit.valueOf(p1_spinner.getSelectedItem().toString())
                    ,p2,Transformations.PressureUnit.valueOf(p2_spinner.getSelectedItem().toString()),
                    ps,ps_unit,0,Transformations.LenghthUnit.m,
                    0,Transformations.LenghthUnit.m,
                    l,Transformations.LenghthUnit.valueOf(l_spinner.getSelectedItem().toString()),
                    0,Transformations.LenghthUnit.m,
                    k,Transformations.AreaUnit.valueOf(k_spinner.getSelectedItem().toString()),
                    area,Transformations.AreaUnit.valueOf(area_spinner.getSelectedItem().toString()),
                    v, Transformations.ViscosityUnit.valueOf(v_spinner.getSelectedItem().toString()),
                    tf,tf_temperatureUnit,ts,ts_temperatureUnit2,B,
                    Transformations.FlowUnit.valueOf(flow_spinner.getSelectedItem().toString()));
        }else if(i==1){
           return flowEquations.getFlowRate(1,p1, Transformations.PressureUnit.valueOf(p1_spinner.getSelectedItem().toString())
                    ,p2,Transformations.PressureUnit.valueOf(p2_spinner.getSelectedItem().toString()),
                    ps,ps_unit,0,Transformations.LenghthUnit.m,
                    0,Transformations.LenghthUnit.m,
                    l,Transformations.LenghthUnit.valueOf(l_spinner.getSelectedItem().toString()),
                    0,Transformations.LenghthUnit.m,
                    k,Transformations.AreaUnit.valueOf(k_spinner.getSelectedItem().toString()),
                    area,Transformations.AreaUnit.valueOf(area_spinner.getSelectedItem().toString()),
                    v, Transformations.ViscosityUnit.valueOf(v_spinner.getSelectedItem().toString()),
                    tf,tf_temperatureUnit,ts,ts_temperatureUnit2,B,
                    Transformations.FlowUnit.valueOf(flow_spinner.getSelectedItem().toString()));
        }else if(i==2){
          return  flowEquations.getFlowRate(2,p1, Transformations.PressureUnit.valueOf(p1_spinner.getSelectedItem().toString())
                    ,p2,Transformations.PressureUnit.valueOf(p2_spinner.getSelectedItem().toString()),
                    ps,ps_unit,0,Transformations.LenghthUnit.m,
                    0,Transformations.LenghthUnit.m,
                    l,Transformations.LenghthUnit.valueOf(l_spinner.getSelectedItem().toString()),
                    0,Transformations.LenghthUnit.m,
                    k,Transformations.AreaUnit.valueOf(k_spinner.getSelectedItem().toString()),
                    area,Transformations.AreaUnit.valueOf(area_spinner.getSelectedItem().toString()),
                    v, Transformations.ViscosityUnit.valueOf(v_spinner.getSelectedItem().toString()),
                    tf,tf_temperatureUnit,ts,ts_temperatureUnit2,B,
                    Transformations.FlowUnit.valueOf(flow_spinner.getSelectedItem().toString()));
        }else if(i==3){
           return flowEquations.getFlowRate(3,p1, Transformations.PressureUnit.valueOf(p1_spinner.getSelectedItem().toString())
                    ,p2,Transformations.PressureUnit.valueOf(p2_spinner.getSelectedItem().toString()),
                    ps,ps_unit,0,Transformations.LenghthUnit.m,
                    0,Transformations.LenghthUnit.m,
                    l,Transformations.LenghthUnit.valueOf(l_spinner.getSelectedItem().toString()),
                    0,Transformations.LenghthUnit.m,
                    k,Transformations.AreaUnit.valueOf(k_spinner.getSelectedItem().toString()),
                    area,Transformations.AreaUnit.valueOf(area_spinner.getSelectedItem().toString()),
                    v, Transformations.ViscosityUnit.valueOf(v_spinner.getSelectedItem().toString()),
                    tf,tf_temperatureUnit,ts,ts_temperatureUnit2,B,
                    Transformations.FlowUnit.valueOf(flow_spinner.getSelectedItem().toString()));
        }else if(i==4){

          return  flowEquations.getFlowRate(4,p1, Transformations.PressureUnit.valueOf(p1_spinner.getSelectedItem().toString())
                    ,p2,Transformations.PressureUnit.valueOf(p2_spinner.getSelectedItem().toString()),
                    ps,ps_unit,r2,Transformations.LenghthUnit.valueOf(r2_spinner.getSelectedItem().toString()),
                    r1,Transformations.LenghthUnit.valueOf(r1_spinner.getSelectedItem().toString()),
                    0,Transformations.LenghthUnit.m,
                    h,Transformations.LenghthUnit.valueOf(h_spinner.getSelectedItem().toString()),
                    k,Transformations.AreaUnit.valueOf(k_spinner.getSelectedItem().toString()),
                    0,Transformations.AreaUnit.m2,
                    v, Transformations.ViscosityUnit.valueOf(v_spinner.getSelectedItem().toString()),
                    tf,tf_temperatureUnit,ts,ts_temperatureUnit2,B,
                    Transformations.FlowUnit.valueOf(flow_spinner.getSelectedItem().toString()));

        }else if(i==5){
         return   flowEquations.getFlowRate(5,p1, Transformations.PressureUnit.valueOf(p1_spinner.getSelectedItem().toString())
                    ,p2,Transformations.PressureUnit.valueOf(p2_spinner.getSelectedItem().toString()),
                    ps,ps_unit,r2,Transformations.LenghthUnit.valueOf(r2_spinner.getSelectedItem().toString()),
                    r1,Transformations.LenghthUnit.valueOf(r1_spinner.getSelectedItem().toString()),
                    0,Transformations.LenghthUnit.m,
                    h,Transformations.LenghthUnit.valueOf(h_spinner.getSelectedItem().toString()),
                    k,Transformations.AreaUnit.valueOf(k_spinner.getSelectedItem().toString()),
                    0,Transformations.AreaUnit.m2,
                    v, Transformations.ViscosityUnit.valueOf(v_spinner.getSelectedItem().toString()),
                    tf,tf_temperatureUnit,ts,ts_temperatureUnit2,B,
                    Transformations.FlowUnit.valueOf(flow_spinner.getSelectedItem().toString()));
        }else if(i==6){
           return flowEquations.getFlowRate(6,p1, Transformations.PressureUnit.valueOf(p1_spinner.getSelectedItem().toString())
                    ,p2,Transformations.PressureUnit.valueOf(p2_spinner.getSelectedItem().toString()),
                    ps,ps_unit,r2,Transformations.LenghthUnit.valueOf(r2_spinner.getSelectedItem().toString()),
                    r1,Transformations.LenghthUnit.valueOf(r1_spinner.getSelectedItem().toString()),
                    l,Transformations.LenghthUnit.valueOf(l_spinner.getSelectedItem().toString()),
                    h,Transformations.LenghthUnit.valueOf(h_spinner.getSelectedItem().toString()),
                    k,Transformations.AreaUnit.valueOf(k_spinner.getSelectedItem().toString()),
                    area,Transformations.AreaUnit.valueOf(area_spinner.getSelectedItem().toString()),
                    v, Transformations.ViscosityUnit.valueOf(v_spinner.getSelectedItem().toString()),
                    tf,tf_temperatureUnit,ts,ts_temperatureUnit2,B,
                    Transformations.FlowUnit.valueOf(flow_spinner.getSelectedItem().toString()));
        }else {
       return flowEquations.getFlowRate(7,p1, Transformations.PressureUnit.valueOf(p1_spinner.getSelectedItem().toString())
                    ,p2,Transformations.PressureUnit.valueOf(p2_spinner.getSelectedItem().toString()),
                    ps,ps_unit,r2,Transformations.LenghthUnit.valueOf(r2_spinner.getSelectedItem().toString()),
                    r1,Transformations.LenghthUnit.valueOf(r1_spinner.getSelectedItem().toString()),
                    0,Transformations.LenghthUnit.m,
                    h,Transformations.LenghthUnit.valueOf(h_spinner.getSelectedItem().toString()),
                    k,Transformations.AreaUnit.valueOf(k_spinner.getSelectedItem().toString()),
                    0,Transformations.AreaUnit.m2,
                    v, Transformations.ViscosityUnit.valueOf(v_spinner.getSelectedItem().toString()),
                    tf,tf_temperatureUnit,ts,ts_temperatureUnit2,B,
                    Transformations.FlowUnit.valueOf(flow_spinner.getSelectedItem().toString()))/z;
        }
    }

    private void showLinear(){
        l_linearLayout.setVisibility(View.VISIBLE);
        area_linearLayout.setVisibility(View.VISIBLE);
        h_linearLayout.setVisibility(View.GONE);
        r2_linearLayout.setVisibility(View.GONE);
        r1_linearLayout.setVisibility(View.GONE);
    }

    private void showRadial(){
        l_linearLayout.setVisibility(View.GONE);
        area_linearLayout.setVisibility(View.GONE);
        h_linearLayout.setVisibility(View.VISIBLE);
        r2_linearLayout.setVisibility(View.VISIBLE);
        r1_linearLayout.setVisibility(View.VISIBLE);
    }

    private void showCombressible(){
        q2_linearLayout.setVisibility(View.VISIBLE);
        q3_linearLayout.setVisibility(View.VISIBLE);
    }

    private AdapterView.OnItemSelectedListener onItemSelectedListener=new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            clear();
            int i=flow_type.getSelectedItemPosition();
            if(i==0){
            showLinear();
            }else if(i==1){
                showLinear();
                showCombressible();
            }else if(i==2){
                showRadial();
            }else {
                showRadial();
                showCombressible();
            }
            switchCode();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

    private View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int i = flow_type.getSelectedItemPosition();
            double x;
            try {
                if (i == 0) {

                   x  = perform(0);
                    Toast.makeText(Flow_equations.this, x+"", Toast.LENGTH_SHORT).show();
                    q1TextView.setText(decimalFormat.format(x) + "");

                } else if (i == 1) {
                    x=perform(1);
                    q1TextView.setText(decimalFormat.format(x) + "");
                    x=perform(2);
                    q2TextView.setText(decimalFormat.format(x) + "");
                    x=perform(3);
                    q3TextView.setText(decimalFormat.format(x) + "");
                }else if(i==2){
                    x=perform(4);
                    q1TextView.setText(decimalFormat.format(x) + "");
                }else if(i==3){
                    x=perform(5);
                    q1TextView.setText(decimalFormat.format(x) + "");
                    x=perform(6);
                    q2TextView.setText(decimalFormat.format(x) + "");
                    x=perform(7);
                    q3TextView.setText(decimalFormat.format(x) + "");
                }

            } catch (Exception e) {
                Toast.makeText(Flow_equations.this, "Check your inputs", Toast.LENGTH_SHORT).show();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flow_equations);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        intialize();
        //additional code
        button.setOnClickListener(onClickListener);
        ts_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(ts_input.getText().toString().equals("")){
                }else {
                    ts_temperatureUnit2=Transformations.TemperatureUnit.valueOf(ts_spinner.getSelectedItem().toString());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ts_input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(ts_input.getText().toString().equals("")){
                    ts=60;
                    ts_temperatureUnit2 =Transformations.TemperatureUnit.F;
                }else {
                    ts=Double.parseDouble( ts_input.getText().toString());
                    ts_temperatureUnit2=Transformations.TemperatureUnit.valueOf(ts_spinner.getSelectedItem().toString());
                }
            }


            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        z_input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(z_input.getText().toString().equals("")){
                    z=1;
                }else {
                    z=Double.parseDouble( z_input.getText().toString());
                }
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        tf_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(tf_input.getText().toString().equals("")){
                }else {
                    tf_temperatureUnit=Transformations.TemperatureUnit.valueOf(tf_spinner.getSelectedItem().toString());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        tf_input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(tf_input.getText().toString().equals("")){
                    tf=60;
                    tf_temperatureUnit =Transformations.TemperatureUnit.F;
                }else {
                    tf=Double.parseDouble( tf_input.getText().toString());
                    tf_temperatureUnit=Transformations.TemperatureUnit.valueOf(tf_spinner.getSelectedItem().toString());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        ps_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(ps_input.getText().toString().equals("")){
                }else {
                    ps_unit=Transformations.PressureUnit.valueOf(ps_spinner.getSelectedItem().toString());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ps_input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(ps_input.getText().toString().equals("")){
                    ps=1;
                    ps_unit =Transformations.PressureUnit.atm;
                }else {
                    ps=Double.parseDouble( ps_input.getText().toString());
                    ps_unit=Transformations.PressureUnit.valueOf(ps_spinner.getSelectedItem().toString());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        b_input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(b_input.getText().toString().equals("")){
                    B=1;
                }else {
                    B=Double.parseDouble(b_input.getText().toString());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        aSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              switchCode();
            }
        });

        flow_type.setOnItemSelectedListener(onItemSelectedListener);
        aSwitch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (aSwitch2.isChecked()){
                    decimalFormat=new DecimalFormat("0.###E0");
                }else {
                    decimalFormat=new DecimalFormat("###.###");
                }try {
                    button.callOnClick();
                }catch (Exception e){

                }
            }
        });
    }

    private void switchCode(){
        if(aSwitch.isChecked()){
            shower(false);
            b_linearLayout.setVisibility(View.VISIBLE);
        }else if(flow_type.getSelectedItemId()==1||flow_type.getSelectedItemId()==3){
            shower(true);
            B=1;
            b_linearLayout.setVisibility(View.GONE);
        }else {
            B=1;
            b_linearLayout.setVisibility(View.GONE);
        }
    }
    private void intialize(){
        button=findViewById(R.id.solve);
        //p2
        LinearLayout p2_linearLayout =findViewById(R.id.p2_linear);
        p2_text=findViewById(R.id.p2_text);
        p2_spinner=findViewById(R.id.p2_spinner);
        p2_input=findViewById(R.id.p2_input);
        ArrayAdapter arrayAdapter=new ArrayAdapter(this, R.layout.spinner_custom2,
                transformations.getUnits("Pressure"));
        arrayAdapter.setDropDownViewResource(R.layout.spinner_custom_drop_down);
        p2_spinner.setAdapter(arrayAdapter);
        //p1
        p1_linearLayout=findViewById(R.id.p1_linear);
        p1_text=findViewById(R.id.p1_text);
        p1_spinner=findViewById(R.id.p1_spinner);
        p1_input=findViewById(R.id.p1_input);
        p1_spinner.setAdapter(arrayAdapter);
        //ps
        ps_linearLayout=findViewById(R.id.ps_linear);
        ps_text=findViewById(R.id.ps_text);
        ps_spinner=findViewById(R.id.ps_spinner);
        ps_input=findViewById(R.id.ps_input);
        ps_spinner.setAdapter(arrayAdapter);
        //r2
        r2_linearLayout=findViewById(R.id.r2_linear);
        r2_text=findViewById(R.id.r2_text);
        r2_spinner=findViewById(R.id.r2_spinner);
        r2_input=findViewById(R.id.r2_input);
        arrayAdapter=new ArrayAdapter(this, R.layout.spinner_custom2,
                transformations.getUnits("Length"));
        arrayAdapter.setDropDownViewResource(R.layout.spinner_custom_drop_down);
        r2_spinner.setAdapter(arrayAdapter);

        //r1
        r1_linearLayout=findViewById(R.id.r1_linear);
        r1_text=findViewById(R.id.r1_text);
        r1_spinner=findViewById(R.id.r1_spinner);
        r1_input=findViewById(R.id.r1_input);
        r1_spinner.setAdapter(arrayAdapter);

        //l
        l_linearLayout=findViewById(R.id.l_linear);
        l_text=findViewById(R.id.l_text);
        l_spinner=findViewById(R.id.l_spinner);
        l_input=findViewById(R.id.l_input);
        l_spinner.setAdapter(arrayAdapter);

        //h
        h_linearLayout=findViewById(R.id.h_linear);
        h_text=findViewById(R.id.h_text);
        h_spinner=findViewById(R.id.h_spinner);
        h_input=findViewById(R.id.h_input);
        h_spinner.setAdapter(arrayAdapter);
        //viscosity
        v_linearLayout=findViewById(R.id.v_linear);
        v_text=findViewById(R.id.v_text);
        v_spinner=findViewById(R.id.v_spinner);
        v_input=findViewById(R.id.v_input);
        arrayAdapter=new ArrayAdapter(this, R.layout.spinner_custom2,
                transformations.getUnits("viscosity"));
        arrayAdapter.setDropDownViewResource(R.layout.spinner_custom_drop_down);
        v_spinner.setAdapter(arrayAdapter);

        //tf
        tf_linearLayout=findViewById(R.id.tf_linear);
        tf_text=findViewById(R.id.tf_text);
        tf_spinner=findViewById(R.id.tf_spinner);
        tf_input=findViewById(R.id.tf_input);
        arrayAdapter=new ArrayAdapter(this, R.layout.spinner_custom2,
                transformations.getUnits("Temperature"));
        arrayAdapter.setDropDownViewResource(R.layout.spinner_custom_drop_down);
        tf_spinner.setAdapter(arrayAdapter);

        //ts
        ts_linearLayout=findViewById(R.id.ts_linear);
        ts_text=findViewById(R.id.ts_text);
        ts_spinner=findViewById(R.id.ts_spinner);
        ts_input=findViewById(R.id.ts_input);
        ts_spinner.setAdapter(arrayAdapter);

        //
        z_linearLayout=findViewById(R.id.z_linear);
        z_input=findViewById(R.id.z_input);

        //area
        area_linearLayout=findViewById(R.id.area_linear);
        area_text=findViewById(R.id.area_text);
        area_spinner=findViewById(R.id.area_spinner);
        area_input=findViewById(R.id.area_input);
        arrayAdapter=new ArrayAdapter(this, R.layout.spinner_custom2,
                transformations.getUnits("Area"));
        arrayAdapter.setDropDownViewResource(R.layout.spinner_custom_drop_down);
        area_spinner.setAdapter(arrayAdapter);

        //k
        k_linearLayout=findViewById(R.id.k_linear);
        k_text=findViewById(R.id.k_text);
        k_spinner=findViewById(R.id.k_spinner);
        k_input=findViewById(R.id.k_input);
        k_spinner.setAdapter(arrayAdapter);

        //B
        b_input=findViewById(R.id.b_input);
        b_linearLayout=findViewById(R.id.b_linear);

        //flow type
        String s[]={"Incompressible linear flow","Compressible linear flow","Incompressible radial flow","Compressible radial flow"};
        flow_type=findViewById(R.id.flow_type);
        arrayAdapter=new ArrayAdapter(this, R.layout.spinner_custom2,
                s  );
        arrayAdapter.setDropDownViewResource(R.layout.spinner_custom_drop_down);
        flow_type.setAdapter(arrayAdapter);
        // formation switch
        aSwitch=findViewById(R.id.b_switch);
        switchLinearLayout=findViewById(R.id.switch_linear);

        //results

        //flowunit
        flow_spinner=findViewById(R.id.q_spinner);
        arrayAdapter=new ArrayAdapter(this, R.layout.spinner_custom2,
                transformations.getUnits("Flow rate"));
        arrayAdapter.setDropDownViewResource(R.layout.spinner_custom_drop_down);
        flow_spinner.setAdapter(arrayAdapter);

        //q1
        q1_linearLayout=findViewById(R.id.q1_linear);
        q1TextView=findViewById(R.id.q1_output);
        //q2
        q2_linearLayout=findViewById(R.id.q2_linear);
        q2TextView=findViewById(R.id.q2_output);
        //q3
        q3_linearLayout=findViewById(R.id.q3_linear);
        q3TextView=findViewById(R.id.q3_output);

        aSwitch2=findViewById(R.id.switch_type);
    }

    private void clear(){
        p1= 0;
        p2=0;
        r2=0;
        r2_linearLayout.setVisibility(View.GONE);
        r1=0;
        r1_linearLayout.setVisibility(View.GONE);
        l=0;
        l_linearLayout.setVisibility(View.GONE);
        h=0;
        h_linearLayout.setVisibility(View.GONE);
        area=0;
        area_linearLayout.setVisibility(View.GONE);
        k=0;

        v=0;

        k=0;


        B=1;
        b_linearLayout.setVisibility(View.GONE);
        aSwitch.setChecked(false);

        q1TextView.setText("");
        q2TextView.setText("");
        q3TextView.setText("");
        q2_linearLayout.setVisibility(View.GONE);
        q3_linearLayout.setVisibility(View.GONE);

        shower(false);
    }

    private void shower(boolean state){
        if(state){
            ps_linearLayout.setVisibility(View.VISIBLE);
            ts_linearLayout.setVisibility(View.VISIBLE);
            z_linearLayout.setVisibility(View.VISIBLE);
            tf_linearLayout.setVisibility(View.VISIBLE);
            B=1;
        }else {
            ps_linearLayout.setVisibility(View.GONE);
            ts_linearLayout.setVisibility(View.GONE);
            z_linearLayout.setVisibility(View.GONE);
            tf_linearLayout.setVisibility(View.GONE);
            ps=1;
            z=1;
            ps_unit=Transformations.PressureUnit.atm;
            tf=60;
            tf_temperatureUnit=Transformations.TemperatureUnit.F;
            ts=60;
            ts_temperatureUnit2 =Transformations.TemperatureUnit.F;
        }
    }
}
