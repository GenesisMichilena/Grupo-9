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


public class Nodo implements Serializable{
    public Contacto dato;
    Nodo siguiente; 
    Nodo anterior; 
    
    public Nodo(Contacto dato) {
        this.dato = dato;
        this.siguiente = this;
        this.anterior = this;
    }

    public Contacto getDato() {
        return dato;
    }

    public void setDato(Contacto dato) {
        this.dato = dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }
}
