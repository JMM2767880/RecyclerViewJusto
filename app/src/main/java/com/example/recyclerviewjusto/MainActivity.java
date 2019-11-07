package com.example.recyclerviewjusto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Intent intentListaPokemon;
    Button btPokemon;

    Intent intentBuscarPokemon;
    Button btBuscarPokemon;

    Intent intentAdd;
    Button btAdd;

    Intent intentBorrar;
    Button btBorrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();
        asignEvents();
    }
    private void initComponents() {
        btPokemon = findViewById(R.id.btPokemon);
        btBuscarPokemon = findViewById(R.id.btBuscar);
        btAdd = findViewById(R.id.btAdd);
        btBorrar = findViewById(R.id.btBorrar);
    }

    private void asignEvents(){
        btPokemon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentListaPokemon = new Intent(MainActivity.this,ListaPokemon.class);
                startActivity(intentListaPokemon);
            }
        });

        btBuscarPokemon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentBuscarPokemon = new Intent(MainActivity.this,BuscarPokemon.class);
                startActivity(intentBuscarPokemon);
            }
        });

        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentAdd = new Intent(MainActivity.this, AddPokemon.class);
                startActivity(intentAdd);
            }
        });

        btBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentBorrar = new Intent(MainActivity.this, BorrarPokemon.class);
                startActivity(intentBorrar);
            }
        });
    }
}
