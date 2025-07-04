/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.pooespol.proyectoestructura;

import java.util.Scanner;

/**
 *
 * @author Home
 */
import java.util.Scanner;

public class ProyectoEstructura {
    public static void main(String[] args) {
        Usuario[] usuarios = {
            new Usuario("Genesis", "1234"),
            new Usuario("Johanna", "abcd")
        };

        Scanner sc = new Scanner(System.in);
        ListaCircularContacto lista = new ListaCircularContacto();
        ContactosFunciones funciones = new ContactosFunciones(sc);

        System.out.println("AGENDA DE CONTACTOS");
        System.out.print("Ingrese su nombre de usuario: ");
        String usuario = sc.nextLine();

        System.out.print("Ingrese su contraseña: ");
        String contrasena = sc.nextLine();

        Usuario usuarioActivo = null;
        for (Usuario u : usuarios) {
            if (u.getNombreUsuario().equals(usuario) && u.getContrasena().equals(contrasena)) {
                usuarioActivo = u;
                break;
            }
        }

        if (usuarioActivo != null) {
            funciones.cargarContactos(lista, usuarioActivo.getNombreUsuario());
            funciones.cargarGrupos(usuarioActivo.getNombreUsuario());

            String nombreUsuario = usuarioActivo.getNombreUsuario();
            System.out.println("\n|_________________________|");
            System.out.printf("|   ¡Bienvenido, \n", nombreUsuario);
            System.out.println("|_________________________|\n");

            int opcion;
            do {
                System.out.println("MENÚ PRINCIPAL");
                System.out.println("1. Crear contacto (persona o empresa)");
                System.out.println("2. Mostrar todos los contactos");
                System.out.println("3. Editar o remover atributos de un contacto");
                System.out.println("4. Eliminar contacto");
                System.out.println("5. Mostrar contactos ordenados");
                System.out.println("6. Filtrar contactos");
                System.out.println("7. Grupos");
                System.out.println("8. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {
                    case 1 -> {
                        Contacto nuevo = funciones.creaContacto();
                        if (nuevo != null) lista.agregar(nuevo);
                    }
                    case 2 -> funciones.mostrarContactos(lista);
                    case 3 -> {
                        Contacto contacto = funciones.seleccionarContacto(lista);
                        if (contacto != null) funciones.editarContacto(contacto);
                    }
                    case 4 -> funciones.eliminarContacto(lista);
                    case 5 -> funciones.ordenarContactos(lista);
                    case 6 -> funciones.filtrarContactos(lista);
                    case 7 -> funciones.gestionarGrupos(lista);
                    case 8 -> {
                        funciones.guardarContactos(lista, usuarioActivo.getNombreUsuario());
                        funciones.guardarGrupos(usuarioActivo.getNombreUsuario());
                        System.out.println("Datos guardados correctamente. Saliendo del sistema...");
                    }
                    default -> System.out.println("Opción inválida. Intente nuevamente.");
                }

            } while (opcion != 8);

        } else {
            System.out.println("Credenciales incorrectas. Acceso denegado.");
        }

        sc.close();
    }
}
