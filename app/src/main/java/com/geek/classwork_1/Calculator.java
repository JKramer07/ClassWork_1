package com.geek.classwork_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class Calculator extends AppCompatActivity {

    private EditText enterText;
    private TextView result;
    private final char ADDITION = '+';
    private final char SUBTRACTION = '-';
    private final char MULTIPLICATION = '*';
    private final char DIVISION = '/';
    private final char EQUAL = 0;
    private char ACTION;
    private Button btnAdd;
    private Button btnSub;
    private Button btnMul;
    private Button btnDiv;
    private Button btnEqual;
    private Button btnClear;
    private double num1 = Double.NaN;
    private double num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        enterText = findViewById(R.id.enterText);
        result = findViewById(R.id.result);
        btnAdd = findViewById(R.id.add);
        btnSub = findViewById(R.id.substract);
        btnDiv = findViewById(R.id.divide);
        btnMul = findViewById(R.id.multiply);
        btnClear = findViewById(R.id.clear);
        btnEqual = findViewById(R.id.equal);

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
                ACTION = SUBTRACTION;
                result.setText(String.valueOf(num1)+"-");
                enterText.setText(null);
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
                ACTION = ADDITION;
                result.setText(String.valueOf(num1)+"+");
                enterText.setText(null);
            }
        });
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
                ACTION = MULTIPLICATION;
                result.setText(String.valueOf(num1)+"*");
                enterText.setText(null);
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
                ACTION = DIVISION;
                result.setText(String.valueOf(num1)+"/");
                enterText.setText(null);
            }
        });
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
                ACTION = EQUAL;
                result.setText(result.getText().toString());
                enterText.setText(null);
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(enterText.getText().length() > 0){
                    CharSequence name = enterText.getText().toString();
                    enterText.setText(name.subSequence(0, name.length()-1));
                }
                else{
                    num1 = Double.NaN;
                    num2 = Double.NaN;
                    enterText.setText(null);
                    result.setText(null);
                }
            }
        });


    }

    public void onNumberClick(View view) {
        Button button = (Button)view;
        enterText.append(button.getText().toString());
    }

    public void calculate(){
        if (!Double.isNaN(num1)){
            num2 = Double.parseDouble(enterText.getText().toString());
            switch (ACTION){
                case ADDITION:
                    num1 = num1+num2;
                    break;
                case SUBTRACTION:
                    num1 = num1-num2;
                    break;
                case MULTIPLICATION:
                    num1 = num1*num2;
                    break;
                case DIVISION:
                    num1 = num1/num2;
                    break;
                case EQUAL:
                    break;
            }
        }
        else {
            num1 = Double.parseDouble(enterText.getText().toString());
        }
    }

}