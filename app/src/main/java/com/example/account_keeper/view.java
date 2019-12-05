package com.example.account_keeper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class view extends AppCompatActivity {
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private Adapter adapter;
    private accounthelper dbHandler;
    private TextView txt_resultadapter;
    private List<account> accountList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        initComponents();
        initRecyclerView();
        cekDataRecyclerView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.Tambahdata) {
            startActivity(new Intent(view.this, add.class));
        } else if (item.getItemId()==R.id.Update){
            startActivity(new Intent(view.this,Update.class));
        } else if (item.getItemId()==R.id.Delete){
            startActivity(new Intent(view.this,Delete.class));
        }

        return true;
    }


    private void initComponents() {

        txt_resultadapter = (TextView) findViewById(R.id.txt_resultadapter);
    }


    private void initRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.rc);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        dbHandler = new accounthelper(view.this);
        accountList = dbHandler.getData();
        adapter = new Adapter(accountList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void cekDataRecyclerView() {
        if (adapter.getItemCount() == 0) {
            txt_resultadapter.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        } else {
            txt_resultadapter.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);


        }
    }
}
