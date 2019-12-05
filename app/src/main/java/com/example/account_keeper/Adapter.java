package com.example.account_keeper;



import android.database.sqlite.SQLiteDatabase;
import android.icu.text.IDNA;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.Viewholder> {
    private List<account> accountList = new ArrayList<>();

    private accounthelper accounthelper;

    public Adapter(List<account> accountList){
        this.accountList = accountList;
    }
    @NonNull
    @Override
    public Adapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent, false);
        Viewholder  viewHolder = new Viewholder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.Viewholder holder, final int position) {
        holder.username.setText(accountList.get(position).getUser());
        holder.password.setText(accountList.get(position).getPass());

    }

    @Override
    public int getItemCount() {
        return accountList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        TextView username,password;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            username = itemView.findViewById(R.id.user);
            password = itemView.findViewById(R.id.pass);

        }


    }
}
