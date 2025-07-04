/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pooespol.proyectoestructura;

import java.io.Serializable;

/**
 *
 * @author Home
 */
public abstract class Contacto implements Serializable {
    
    protected String telefonoMovil, telefonoFijo, correo;
    protected String redesSociales;
    protected String pais; 

    public Contacto(String telefonoMovil, String telefonoFijo, String correo, String redesSociales, String pais) {
        this.telefonoMovil = telefonoMovil;
        this.telefonoFijo = telefonoFijo;
        this.correo = correo;
        this.redesSociales = redesSociales;
        this.pais = pais;
    }

    public String getTelefonoMovil() {
        return telefonoMovil;
    }

    public void setTelefonoMovil(String telefonoMovil) {
        this.telefonoMovil = telefonoMovil;
    }

    public String getTelefonoFijo() {
        return telefonoFijo;
    }

    public void setTelefonoFijo(String telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getRedesSociales() {
        return redesSociales;
    }

    public void setRedesSociales(String redesSociales) {
        this.redesSociales = redesSociales;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    
    public abstract String obtenerNombre();
    public abstract String obtenerInformacionContacto();

    
}
