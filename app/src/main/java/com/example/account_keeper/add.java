package com.example.account_keeper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

public class add extends AppCompatActivity {
    EditText inuser, inpass;
    Button btnsimpan, btnupdate, btndelete;

    private accounthelper accounthelper;
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);


        accounthelper = new accounthelper(this);
        initComponents();
    }

    private void initComponents() {

        inuser = findViewById(R.id.username);
        inpass = findViewById(R.id.password);
        btnsimpan = findViewById(R.id.additem);
        btnupdate = findViewById(R.id.update);
        btndelete = findViewById(R.id.delete);

        btnsimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validasiForm();
                startActivity(new Intent(add.this, view.class));
            }
        });


    }

    private void validasiForm() {
        String form_user = inuser.getText().toString();
        String form_pass = inpass.getText().toString();

        if (form_user.isEmpty() || form_pass.isEmpty()) {
            Toast.makeText(add.this, "Data Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();

        } else {
            accounthelper.tambahdata(new account(form_user, form_pass));
            List<account> accountList = accounthelper.getData();
            adapter = new Adapter(accountList);
            adapter.notifyDataSetChanged();

            Toast.makeText(add.this, "Berhasil Menambahkan Data", Toast.LENGTH_SHORT).show();
        }
    }

    ;
}

