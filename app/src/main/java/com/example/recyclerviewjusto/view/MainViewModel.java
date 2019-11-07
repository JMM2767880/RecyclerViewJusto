package com.example.recyclerviewjusto.view;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.recyclerviewjusto.entity.Pokemon;
import com.example.recyclerviewjusto.model.Repository;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private Repository repository;

    private LiveData<List<Pokemon>> pokemon;

    private List<Pokemon> pokemons;

    public MainViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
        pokemon = repository.getPokemonLive();
    }

    public LiveData<List<Pokemon>> getPokemon() {
        return pokemon;
    }


    public void insert(Pokemon pokemon) {
        repository.insertPokemon(pokemon);
    }

}
