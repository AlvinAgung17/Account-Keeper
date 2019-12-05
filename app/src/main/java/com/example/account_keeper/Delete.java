package com.example.account_keeper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Delete extends AppCompatActivity {
    Button btndelete;
    EditText inputdelete;
    private accounthelper accounthelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        accounthelper = new accounthelper(this);

        btndelete = findViewById(R.id.delete);
        inputdelete = findViewById(R.id.username);


        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = inputdelete.getText().toString();

                if (user.isEmpty()) {
                    Toast.makeText(Delete.this, "Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
                } else {
                    int a = accounthelper.delete(user);
                    if (a <= 0) {
                        Toast.makeText(Delete.this, "Gagal Melakukan Hapus", Toast.LENGTH_SHORT).show();
                        inputdelete.setText("");
                        inputdelete.requestFocus();
                    } else {
                        Toast.makeText(Delete.this, "Sukses Terhapus", Toast.LENGTH_SHORT).show();
                        inputdelete.setText("");
                        startActivity(new Intent(Delete.this,view.class));
                    }
                }
            }

        });
    }
}
