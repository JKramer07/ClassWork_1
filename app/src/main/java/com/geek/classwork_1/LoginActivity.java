package com.geek.classwork_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.geek.classwork_1.R.drawable.back_edittext3;

public class LoginActivity extends AppCompatActivity {

    Button btn;
    EditText editText1, editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn = findViewById(R.id. enterbutton);
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(editText1.getText().toString())){
                    editText1.setError("Enter email");
                }
                if (TextUtils.isEmpty(editText2.getText().toString())){
                    editText2.setError("Enter password");
                }
                if (!TextUtils.isEmpty(editText1.getText().toString()) && !TextUtils.isEmpty(editText2.getText().toString())){
                    Toast.makeText(LoginActivity.this, "Welcome to the Candy Shop", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this, Calculator.class));
                    finish();
                }
            }
        });

        editText2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!editText1.getText().toString().isEmpty() && !editText2.getText().toString().isEmpty()){
                    btn.setBackground(getResources().getDrawable(back_edittext3));
                }
                else{
                    btn.setBackground(getResources().getDrawable(R.drawable.back_edittext));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }
}