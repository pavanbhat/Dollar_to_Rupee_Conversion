package com.example.pavan.conversion;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText t,t1; RadioButton r1,r2; Button b; RadioGroup rg; boolean flag; int tag = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t = (EditText)findViewById(R.id.editText);
        t1 = (EditText)findViewById(R.id.editText3);
        r1 = (RadioButton)findViewById(R.id.radioButton);
        r2 = (RadioButton)findViewById(R.id.radioButton2);
        b = (Button)findViewById(R.id.button);
        rg = (RadioGroup)findViewById(R.id.radio);
        /*if (!r1.isChecked() && !r2.isChecked()){
            while(true){
                if(!t.getText().toString().isEmpty()){
                    t1.setEnabled(false);
                    break;
                }
                else if(!t1.getText().toString().isEmpty()){
                    t.setEnabled(false);
                    break;
                }
            }
        }*/

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == r1.getId()){
                    flag = true;
                    t.setEnabled(true);
                    t1.setEnabled(false);
                    tag++;
                }
                else if(i == r2.getId()){
                    flag = false;
                    t.setEnabled(false);
                    t1.setEnabled(true);
                    tag++;
                }
                    t.setText("");
                    t1.setText("");

            }
        });



        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!r1.isChecked() && !r2.isChecked()){
                    Toast t = Toast.makeText(MainActivity.this, "Please click on either Dollar or Rupees!", Toast.LENGTH_LONG);
                    t.show();
                }
                String s = ""; double value = 0;
                if(flag){
                    s = t.getText().toString();
                    value = Double.parseDouble(s);
                    value *= 68;
                    t1.setText(""+value);
                }
                else{
                    s = t1.getText().toString();
                    value = Double.parseDouble(s);
                    value /= 68;
                    t.setText(""+value);
                }

            }
        });

    }
}
