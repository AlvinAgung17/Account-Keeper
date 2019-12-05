package com.example.account_keeper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText user,pass;
    Button btnadd;
    TextView Lupa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.username);
        pass = findViewById(R.id.password);
        btnadd = findViewById(R.id.btnlogin);


        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user.getText().toString().equals("admin") && pass.getText().toString().equals("admin")){
                    Intent intent = new Intent(MainActivity.this,view.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(MainActivity.this,"Username Or Password Is Worng",Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}