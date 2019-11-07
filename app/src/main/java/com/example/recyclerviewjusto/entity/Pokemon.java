package com.example.recyclerviewjusto.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "pokemon")
public class Pokemon {

    @PrimaryKey(autoGenerate = true)
    private long id;

    @ColumnInfo(name = "nombre")
    private String nombre;

    @ColumnInfo(name = "tipo")
    private String tipo;

    @ColumnInfo(name = "debilidad")
    private String debilidad;

    @ColumnInfo(name = "peso")
    private double peso;

    @ColumnInfo(name = "altura")
    private double altura;

    @ColumnInfo(name = "imagen")
    private int imagen;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDebilidad() {
        return debilidad;
    }

    public void setDebilidad(String debilidad) {
        this.debilidad = debilidad;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", debilidad='" + debilidad + '\'' +
                ", peso='" + peso + '\'' +
                ", altura='" + altura + '\'' +
                ", imagen='" + imagen + '\'' +
                '}';
    }
}