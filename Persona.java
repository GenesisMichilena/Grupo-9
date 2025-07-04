/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pooespol.proyectoestructura;

/**
 *
 * @author Home
 */
public class Persona extends Contacto {
    private String nombre;
    private String apellido;
    private String cumpleaños;
    private String ciudad;

    public Persona(String nombre, String apellido, String cumpleaños, String ciudad,
                   String telefonoMovil, String telefonoFijo, String correo,
                   String redesSociales, String pais) {
        super(telefonoMovil, telefonoFijo, correo, redesSociales, pais);
        this.nombre = nombre;
        this.apellido = apellido;
        this.cumpleaños = cumpleaños;
        this.ciudad = ciudad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCumpleaños() {
        return cumpleaños;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCumpleaños(String cumpleaños) {
        this.cumpleaños = cumpleaños;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String obtenerNombre() {
        return nombre + " " + apellido;
    }

    @Override
    public String obtenerInformacionContacto() {
        return "Nombre: " + nombre + "\n"
             + "Apellido: " + apellido + "\n"
             + "Cumpleaños: " + cumpleaños + "\n"
             + "Ciudad: " + ciudad + "\n"
             + "Teléfono móvil: " + telefonoMovil + "\n"
             + "Teléfono fijo: " + telefonoFijo + "\n"
             + "Correo: " + correo + "\n"
             + "Redes sociales: " + redesSociales + "\n"
             + "País: " + pais;
    }
}