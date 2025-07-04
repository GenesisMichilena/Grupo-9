/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pooespol.proyectoestructura;

/**
 *
 * @author Home
 */
public class Empresa extends Contacto {
    private String nombreEmpresa;
    private String numeroRuc;
    private String direccion;
    private String sitioWeb;

    public Empresa(String nombreEmpresa, String numeroRuc, String direccion, String sitioWeb,
                   String telefonoMovil, String telefonoFijo, String correo,
                   String redesSociales, String pais) {
        super(telefonoMovil, telefonoFijo, correo, redesSociales, pais);
        this.nombreEmpresa = nombreEmpresa;
        this.numeroRuc = numeroRuc;
        this.direccion = direccion;
        this.sitioWeb = sitioWeb;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public String getNumeroRuc() {
        return numeroRuc;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getSitioWeb() {
        return sitioWeb;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public void setNumeroRuc(String numeroRuc) {
        this.numeroRuc = numeroRuc;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setSitioWeb(String sitioWeb) {
        this.sitioWeb = sitioWeb;
    }

    @Override
    public String obtenerNombre() {
        return nombreEmpresa;
    }

    @Override
    public String obtenerInformacionContacto() {
        return "Nombre Empresa: " + nombreEmpresa + "\n"
             + "RUC: " + numeroRuc + "\n"
             + "Dirección: " + direccion + "\n"
             + "Sitio web: " + sitioWeb + "\n"
             + "Teléfono móvil: " + telefonoMovil + "\n"
             + "Teléfono fijo: " + telefonoFijo + "\n"
             + "Correo: " + correo + "\n"
             + "Redes sociales: " + redesSociales + "\n"
             + "País: " + pais;
    }
}