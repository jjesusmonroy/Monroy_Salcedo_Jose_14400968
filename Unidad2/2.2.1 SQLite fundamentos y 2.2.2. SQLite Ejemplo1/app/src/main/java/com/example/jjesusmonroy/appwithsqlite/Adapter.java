package com.example.jjesusmonroy.appwithsqlite;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * Created by jjesusmonroy on 27/02/18.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.RecyclerViewHolder> {
    private String [][] data;

    public Adapter(String[][] data) {
        this.data = data;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.nombre.setText(data[position][1]);
        holder.nocontrol.setText(data[position][2]);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView nombre,nocontrol;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            nombre=itemView.findViewById(R.id.nombre);
            nocontrol=itemView.findViewById(R.id.nocontrol);
        }
    }
}
