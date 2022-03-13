package com.example.tutorial_02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_tem;
    RadioButton rd_btn_c;
    RadioButton rd_btn_f;
    Button btn_calculater;
    TextView tv_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_tem =findViewById(R.id.et_tem);
        rd_btn_c = findViewById(R.id.rd_btn_c);
        rd_btn_f = findViewById(R.id.rd_btn_f);
        btn_calculater = findViewById(R.id.btn_calculater);
        tv_view = findViewById(R.id.tv_view);
    }

    @Override
    protected void onResume() {
        super.onResume();
        btn_calculater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateAnswer();
            }
        });
    }

    public void calculateAnswer(){
        Calculations cal = new Calculations();
        String value = et_tem.getText().toString();
        if(TextUtils.isEmpty(value)){
            Toast.makeText(this, "Enter Temperature Value!!!", Toast.LENGTH_SHORT).show();
        }else{
            //change the string value to float value
            Float tem = Float.parseFloat(value);
            if(rd_btn_c.isChecked()){
                tem = cal.convertCelciusToFahrenheit(tem);
            }else if(rd_btn_f.isChecked()){
                tem = cal.convertFahrenheitToCelcius(tem);
            }else{
                Toast.makeText(this, "Select the Radio Button!!!", Toast.LENGTH_SHORT).show();
                tem = 0.0f;
            }
            //Display Massage
            tv_view.setText(new Float(tem).toString());
        }
    }
}