package com.proyecto.ProyectoFinal.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombrePizza;
    private String ingredientes;
    private String tamanio; // corregido de "tamaño" a "tamanio"
    private int cantidad;

    private String cliente; // ✅ este es el nuevo campo
    private String direccionEntrega;
    private String telefonoContacto;

    public Pedido() {}

    public Pedido(String nombrePizza, String ingredientes, String tamanio, int cantidad,
                  String cliente, String direccionEntrega, String telefonoContacto) {
        this.nombrePizza = nombrePizza;
        this.ingredientes = ingredientes;
        this.tamanio = tamanio;
        this.cantidad = cantidad;
        this.cliente = cliente;
        this.direccionEntrega = direccionEntrega;
        this.telefonoContacto = telefonoContacto;
    }

    // Getters y setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombrePizza() { return nombrePizza; }
    public void setNombrePizza(String nombrePizza) { this.nombrePizza = nombrePizza; }

    public String getIngredientes() { return ingredientes; }
    public void setIngredientes(String ingredientes) { this.ingredientes = ingredientes; }

    public String getTamanio() { return tamanio; }
    public void setTamanio(String tamanio) { this.tamanio = tamanio; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    public String getCliente() { return cliente; } // ✅ getter
    public void setCliente(String cliente) { this.cliente = cliente; } // ✅ setter

    public String getDireccionEntrega() { return direccionEntrega; }
    public void setDireccionEntrega(String direccionEntrega) { this.direccionEntrega = direccionEntrega; }

    public String getTelefonoContacto() { return telefonoContacto; }
    public void setTelefonoContacto(String telefonoContacto) { this.telefonoContacto = telefonoContacto; }
}
