package com.example.jjesusmonroy.cardviewunidad1;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import static com.example.jjesusmonroy.cardviewunidad1.R.drawable.ic_launcher_background;

/**
 * Created by jjesusmonroy on 25/02/18.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.RecyclerViewHolder> {

    private List<DataProvider> list;

    public Adapter(List<DataProvider> list) {
        this.list = list;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        DataProvider musica = list.get(position);

        holder.genero.setText(musica.getGenero());
        holder.titulo.setText(musica.getTitulo());
        holder.imagen.setImageResource(R.drawable.ic_launcher_background);
        holder.card.setCardBackgroundColor(musica.getColor());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView genero,titulo;
        ImageView imagen;
        CardView card;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            genero=itemView.findViewById(R.id.genero);
            titulo=itemView.findViewById(R.id.titulo);
            imagen=itemView.findViewById(R.id.imagen);
            card=itemView.findViewById(R.id.cardView);

        }
    }
}
