package com.geek.classwork_1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    Button btn;
    EditText editText1, editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        btn = findViewById(R.id. enterbutton);
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);

        btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(editText1.getText().toString())){
                    editText1.setError("Enter email");
                }
                if (TextUtils.isEmpty(editText2.getText().toString())){
                    editText2.setError("Enter password");
                }
                if (!TextUtils.isEmpty(editText1.getText().toString()) && !TextUtils.isEmpty(editText2.getText().toString())){
                    btn.setBackgroundColor(R.color.green);
                    Toast.makeText(LoginActivity.this, "Welcome to the Candy Shop", Toast.LENGTH_LONG).show();
                } else{
                    btn.setBackgroundColor(R.color.blue);
                }

            }
        });
    }


}
