package com.example.sqlite;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    Context context;
    private ArrayList id_hewan, nama_hewan, breed, jk, umur;

    RecyclerAdapter(Context context,
                    ArrayList id_hewan,
                    ArrayList nama_hewan,
                    ArrayList breed,
                    ArrayList jk,
                    ArrayList umur){
        this.context = context;
        this.id_hewan = id_hewan;
        this.nama_hewan = nama_hewan;
        this.breed = breed;
        this.jk = jk;
        this.umur = umur;
    }

    @NonNull
    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.rec_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.MyViewHolder holder, int position) {
        holder.id_hewan_txt.setText(String.valueOf(id_hewan.get(position)));
        holder.nama_hewan_txt.setText(String.valueOf(nama_hewan.get(position)));
        holder.breed_txt.setText(String.valueOf(breed.get(position)));
        holder.jk_txt.setText(String.valueOf(jk.get(position)));
        holder.umur_txt.setText(String.valueOf(umur.get(position)));
    }

    @Override
    public int getItemCount() {
        return id_hewan.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView id_hewan_txt, nama_hewan_txt, breed_txt, jk_txt, umur_txt;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            id_hewan_txt = itemView.findViewById(R.id.displayidhewan);
            nama_hewan_txt = itemView.findViewById(R.id.displaynama);
            breed_txt = itemView.findViewById(R.id.displaybreed);
            jk_txt = itemView.findViewById(R.id.displaygender);
            umur_txt = itemView.findViewById(R.id.displayage);
        }
    }
}
