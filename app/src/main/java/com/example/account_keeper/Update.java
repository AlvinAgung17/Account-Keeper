package com.example.account_keeper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.IDNA;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Update extends AppCompatActivity {
    EditText inuser,inpass,usernamelama;
    Button btnupdate;
    private accounthelper accounthelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        accounthelper = new accounthelper(this);

        usernamelama = findViewById(R.id.usernamelama);
        inuser = findViewById(R.id.username);
        inpass = findViewById(R.id.password);
        btnupdate = findViewById(R.id.update);

        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String u1 = inuser.getText().toString();
                String u2 = inpass.getText().toString();
                String u3 = usernamelama.getText().toString();


                    int a=accounthelper.updateaccount(u3,u1);
                    if(a<=0){
                        Toast.makeText(Update.this, "Data Gagal Di Update", Toast.LENGTH_SHORT).show();
                        inuser.setText("");
                        usernamelama.setText("");
                        inpass.setText("");
                        inuser.requestFocus();

                    }else{
                        inuser.setText("");
                        usernamelama.setText("");
                        inpass.setText("");
                        Toast.makeText(Update.this, "Data Berhasil Di Update", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Update.this,view.class));
                    }
                }

        });


    }
}
