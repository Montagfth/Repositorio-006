package com.proyecto.ProyectoFinal.Model;

import jakarta.validation.constraints.*;

public class RegistroDTO {
    @NotBlank
    private String nombre;

    @NotBlank
    @Pattern(regexp = "\\d{8}", message="El DNI debe tener exactamente 8 dígitos")
    private String dni;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Pattern(regexp = "\\d{9}", message="El teléfono debe tener exactamente 9 dígitos")
    private String telefono;

    @NotBlank
    private String password;

    // --- GETTERS ---
    public String getNombre() { return nombre; }
    public String getDni() { return dni; }
    public String getEmail() { return email; }
    public String getTelefono() { return telefono; }
    public String getPassword() { return password; }

    // --- SETTERS ---
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setDni(String dni) { this.dni = dni; }
    public void setEmail(String email) { this.email = email; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public void setPassword(String password) { this.password = password; }
}
