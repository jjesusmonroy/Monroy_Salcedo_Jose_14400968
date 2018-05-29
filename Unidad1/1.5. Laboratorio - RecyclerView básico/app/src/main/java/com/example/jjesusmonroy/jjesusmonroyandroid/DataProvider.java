package com.example.jjesusmonroy.jjesusmonroyandroid;

/**
 * Created by jjesusmonroy on 23/02/18.
 */

public class DataProvider {
    private String nombre,nocontrol,carrera;

    public DataProvider(String nombre, String nocontrol, String carrera) {
        this.nombre = nombre;
        this.nocontrol = nocontrol;
        this.carrera = carrera;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNocontrol() {
        return nocontrol;
    }

    public String getCarrera() {
        return carrera;
    }
}
