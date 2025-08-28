package com.proyecto.ProyectoFinal.Model;

public class Pizza {
    private String nombre;
    private double precio;

    public Pizza(String nombre,double precio ){
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
}
