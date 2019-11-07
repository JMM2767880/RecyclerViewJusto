package com.example.recyclerviewjusto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.recyclerviewjusto.entity.Pokemon;
import com.example.recyclerviewjusto.view.MainViewModel;

import java.io.IOException;

public class AddPokemon extends AppCompatActivity {

    ArrayAdapter<CharSequence> adapter1, adapter2;

    Spinner spinnerTipos, spinnerDebilidad;

    private static final int FOTO_SELECCIONADA = 1;

    Button btImagen;
    ImageView fotoPokemon;
    EditText etNombre, etPeso, etAltura;
    Button btInsertar;
    boolean campoVacio = true;
    Pokemon pokemonNuevo;

    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pokemon);

        initComponents();
        asignEvents();
        insertar();
    }

    private void initComponents() {
        spinnerTipos = findViewById(R.id.spinner);
        spinnerDebilidad = findViewById(R.id.spinner2);
        btImagen = findViewById(R.id.btImagen);
        fotoPokemon = findViewById(R.id.fotoPokemon);
        etNombre = findViewById(R.id.etNombre);
        etPeso = findViewById(R.id.etPeso);
        etAltura = findViewById(R.id.etAltura);
        btInsertar = findViewById(R.id.btInsertar);

        adapter1 = ArrayAdapter.createFromResource(this,
                R.array.tipos, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adapter2 = ArrayAdapter.createFromResource(this,
                R.array.debilidad, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerTipos.setAdapter(adapter1);
        spinnerDebilidad.setAdapter(adapter2);

    }

    private void asignEvents() {
        btImagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentFoto = new Intent(Intent.ACTION_GET_CONTENT,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intentFoto, FOTO_SELECCIONADA);
            }
        });

    }

    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == FOTO_SELECCIONADA && resultCode == RESULT_OK &&
                data != null && data.getData() != null) {
            Uri imageUri = data.getData();
            Bitmap bitmapBig = null;
            try {
                bitmapBig =
                        MediaStore.Images.Media.getBitmap(this.getContentResolver(),
                                imageUri);
            } catch (IOException e) {
                Log.d("esc exception", "no crea bitmap");
                e.printStackTrace();
            }
            Glide.with(this)
                    .load(imageUri)
                    .override(500, 500)// prueba de escalado
                    .into(fotoPokemon);
        }
    }

    private void insertar(){
        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        btInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etNombre.getText().toString().equals("")){
                    campoVacio = false;
                }

                if (etPeso.getText().toString().equals("")){
                    campoVacio = false;
                }

                if (etAltura.getText().toString().equals("")){
                    campoVacio = false;
                }

                String tipo = spinnerTipos.getSelectedItem().toString();
                String debilidad = spinnerDebilidad.getSelectedItem().toString();

                if (campoVacio == true){
                    pokemonNuevo = new Pokemon();
                    pokemonNuevo.setNombre(etNombre.getText().toString());
                    pokemonNuevo.setTipo(tipo);
                    pokemonNuevo.setDebilidad(debilidad);
                    pokemonNuevo.setAltura(Double.parseDouble(etAltura.getText().toString()));
                    pokemonNuevo.setPeso(Double.parseDouble(etPeso.getText().toString()));
                    pokemonNuevo.setImagen(1);
                    viewModel.insert(pokemonNuevo);
                    Toast toast = Toast.makeText(getApplicationContext(), "Pokemon Insertado", Toast.LENGTH_LONG);
                    toast.show();
                }else{
                    Toast toast = Toast.makeText(getApplicationContext(), "No puede quedar ningún campo vacío", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });

    }
}
