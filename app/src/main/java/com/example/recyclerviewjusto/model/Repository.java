package com.example.recyclerviewjusto.model;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.example.recyclerviewjusto.dao.PokemonDAO;
import com.example.recyclerviewjusto.database.PokemonDatabase;
import com.example.recyclerviewjusto.entity.Pokemon;

import java.util.List;

public class Repository {

    private PokemonDAO pokemonDAO;
    private LiveData<List<Pokemon>> pokemonLive;
    private List<Pokemon> pokemons;

    public Repository(Context contexto) {
        PokemonDatabase db = PokemonDatabase.getDatabase(contexto);
        pokemonDAO = db.getPokemonDAO();
        pokemonLive = pokemonDAO.getAllLive();
    }

    /*private void populateDb() {
        for (int i = 0; i < 100; i++) {
            User user = new User();
            user.setApellidos("Pérez " + i);
            user.setNombre("Paco " + i);
            insertUser(user);
        }
    }*/

    public LiveData<List<Pokemon>> getPokemonLive() {
        return pokemonLive;
    }

    public void insertPokemon(Pokemon pokemon) {
        new InsertThread().execute(pokemon);
    }

    private class InsertThread extends AsyncTask<Pokemon, Void, Void> {

        @Override
        protected Void doInBackground(Pokemon... pokemons) {
            pokemonDAO.insert(pokemons[0]);
            Log.v("xyz", pokemons[0].toString());
            return null;
        }
    }

}