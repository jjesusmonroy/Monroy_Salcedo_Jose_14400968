package com.example.jjesusmonroy.cardviewunidad1;

/**
 * Created by jjesusmonroy on 25/02/18.
 */

public class DataProvider {

    private String genero,titulo;
    int color;

    public DataProvider(String genero, String titulo, int color) {
        this.genero = genero;
        this.titulo = titulo;
        this.color = color;
    }

    public String getGenero() {
        return genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getColor() {
        return color;
    }
}
