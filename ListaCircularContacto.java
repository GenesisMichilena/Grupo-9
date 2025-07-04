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
public class ListaCircularContacto implements Serializable {
    private Nodo inicio;

    public ListaCircularContacto() {
        this.inicio = null;
    }

    public boolean estaVacia() {
        return inicio == null;
    }
   
    public Nodo getCabeza() {
        return inicio;
    }
    
    
    public Nodo getInicio() {
        return inicio;
    }
 
     public void agregar(Contacto contacto) {
        Nodo nuevo = new Nodo(contacto);
        if (inicio == null) {
            inicio = nuevo;
            inicio.setSiguiente(inicio);
            inicio.setAnterior(inicio);
        } else {
            Nodo ultimo = inicio.getAnterior();
            ultimo.setSiguiente(nuevo);
            nuevo.setAnterior(ultimo);
            nuevo.setSiguiente(inicio);
            inicio.setAnterior(nuevo);
        }
    }
      public Contacto remove(int index) {
        if (inicio == null || index < 0) return null;

        Nodo actual = inicio;
        int contador = 0;

        do {
            if (contador == index) {
                if (actual.getSiguiente() == actual) {
                    Contacto dato = actual.getDato();
                    inicio = null;
                    return dato;
                }
                actual.getAnterior().setSiguiente(actual.getSiguiente());
                actual.getSiguiente().setAnterior(actual.getAnterior());
                if (actual == inicio) inicio = actual.getSiguiente();
                return actual.getDato();
            }
            actual = actual.getSiguiente();
            contador++;
        } while (actual != inicio);

        return null;
    }

    public void mostrar() {
        if (estaVacia()) {
            System.out.println("Lista vacía.");
            return;
        }

        Nodo aux = inicio;
        do {
            System.out.println(aux.dato.obtenerNombre() + " - " + aux.dato.obtenerInformacionContacto());
            aux = aux.siguiente;
        } while (aux != inicio);
    }
    public boolean eliminarPorObjeto(Contacto c) {
    if (inicio == null) return false;

    Nodo actual = inicio;
    Nodo anterior = null;

    do {
        if (actual.getDato().equals(c)) {
            if (actual == inicio && actual.getSiguiente() == inicio) {
                inicio = null;
            } else {
                if (actual == inicio) {
                    Nodo temp = inicio;
                    while (temp.getSiguiente() != inicio) {
                        temp = temp.getSiguiente();
                    }
                    temp.setSiguiente(inicio.getSiguiente());
                    inicio = inicio.getSiguiente();
                } else {
                    anterior.setSiguiente(actual.getSiguiente());
                }
            }
            return true;
        }
        anterior = actual;
        actual = actual.getSiguiente();
    } while (actual != inicio);

    return false;
}

}

