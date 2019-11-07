package com.example.recyclerviewjusto;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewjusto.entity.Pokemon;

import java.util.List;


public class Adapter extends RecyclerView.Adapter<Adapter.PokemonViewHolder> {
    private List<Pokemon> items;

    public static class PokemonViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        public ImageView imagen;
        public TextView nombre;
        public TextView tipo;

        public PokemonViewHolder(View v) {
            super(v);
            imagen = v.findViewById(R.id.imagen);
            nombre = v.findViewById(R.id.nombre);
            tipo = v.findViewById(R.id.tipo);
        }
    }

    public Adapter(List<Pokemon> items) {
        this.items = items;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public PokemonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cardview, viewGroup, false);
        return new PokemonViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PokemonViewHolder viewHolder, int i) {
        viewHolder.imagen.setImageResource(items.get(i).getImagen());
        viewHolder.nombre.setText(items.get(i).getNombre());
        viewHolder.tipo.setText("Tipo:"+String.valueOf(items.get(i).getTipo()));
    }
}