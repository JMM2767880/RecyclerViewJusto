package com.example.recyclerviewjusto;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;;import com.example.recyclerviewjusto.entity.Pokemon;
import com.example.recyclerviewjusto.view.MainViewModel;

import java.util.ArrayList;
import java.util.List;

public class ListaPokemon extends AppCompatActivity {

    Pokemon pokemonNuevo;
    private MainViewModel viewModel;
    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pokemon);

        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        Log.v("AAAA",viewModel.getPokemon().toString());

    }

}
