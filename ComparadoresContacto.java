/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pooespol.proyectoestructura;

import java.util.Comparator;

/**
 *
 * @author Home
 */
import java.util.Comparator;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ComparadoresContacto {

    public static Comparator<Contacto> porNombre() {
        return Comparator.comparing(Contacto::obtenerNombre, String.CASE_INSENSITIVE_ORDER);
    }

    public static Comparator<Contacto> porPais() {
        return Comparator.comparing(Contacto::getPais, String.CASE_INSENSITIVE_ORDER);
    }

    public static Comparator<Contacto> porNombreYPais() {
        return Comparator
                .comparing(Contacto::obtenerNombre, String.CASE_INSENSITIVE_ORDER)
                .thenComparing(Contacto::getPais, String.CASE_INSENSITIVE_ORDER);
    }

    public static Comparator<Contacto> porRedesSociales() {
        return Comparator.comparing(Contacto::getRedesSociales, String.CASE_INSENSITIVE_ORDER);
    }

    public static Comparator<Contacto> porCumpleanios() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return Comparator.comparing(contacto -> {
            if (contacto instanceof Persona p) {
                try {
                    return LocalDate.parse(p.getCumpleaños(), formatter);
                } catch (DateTimeParseException e) {
                    return LocalDate.MIN;
                }
            }
            return LocalDate.MIN;
        });
    }
}
