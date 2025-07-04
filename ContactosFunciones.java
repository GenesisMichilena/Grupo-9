
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pooespol.proyectoestructura;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * @author Home
 */

public class ContactosFunciones {
    private Scanner sc;
    private Map<String, ListaCircularContacto> grupos = new HashMap<>();

    public ContactosFunciones(Scanner sc) {
        this.sc = sc;
    }

    public Contacto creaContacto() {
        System.out.print("Ingrese tipo de contacto (-p para persona, -e para empresa): ");
        String tipo = sc.nextLine().trim().toLowerCase();

        switch (tipo) {
            case "-p":
                return crearPersona();
            case "-e":
                return crearEmpresa();
            default:
                System.out.println("Tipo de contacto no válido.");
                return null;
        }
    }

    public Persona crearPersona() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Apellido: ");
        String apellido = sc.nextLine();
        System.out.print("Cumpleaños: ");
        String cumpleaños = sc.nextLine();
        System.out.print("Ciudad: ");
        String ciudad = sc.nextLine();
        System.out.print("Teléfono móvil: ");
        String telMovil = sc.nextLine();
        System.out.print("Teléfono fijo: ");
        String telFijo = sc.nextLine();
        System.out.print("Correo: ");
        String correo = sc.nextLine();
        System.out.print("Redes sociales: ");
        String redes = sc.nextLine();
        System.out.print("País: ");
        String pais = sc.nextLine();

        return new Persona(nombre, apellido, cumpleaños, ciudad, telMovil, telFijo, correo, redes, pais);
    }

    public Empresa crearEmpresa() {
        System.out.print("Nombre empresa: ");
        String nombreEmp = sc.nextLine();
        System.out.print("RUC: ");
        String ruc = sc.nextLine();
        System.out.print("Dirección: ");
        String direccion = sc.nextLine();
        System.out.print("Sitio web: ");
        String web = sc.nextLine();
        System.out.print("Redes sociales: ");
        String redes = sc.nextLine();
        System.out.print("País: ");
        String pais = sc.nextLine();
        System.out.print("Teléfono móvil: ");
        String telMovil = sc.nextLine();
        System.out.print("Teléfono fijo: ");
        String telFijo = sc.nextLine();
        System.out.print("Correo: ");
        String correo = sc.nextLine();

        return new Empresa(nombreEmp, ruc, direccion, web, telMovil, telFijo, correo, redes, pais);
    }

    public void editarContacto(Contacto contacto) {
        System.out.println("¿Qué desea hacer?");
        System.out.println("1. Editar atributos");
        System.out.println("2. Remover atributos");
        System.out.print("Seleccione una opción: ");
        int opcion = Integer.parseInt(sc.nextLine());

        switch (opcion) {
            case 1 -> editarAtributos(contacto);
            case 2 -> removerAtributos(contacto);
            default -> System.out.println("Opción inválida.");
        }
    }

    public void editarAtributos(Contacto contacto) {
        System.out.println("¿Qué desea editar?");
        System.out.println("1. Teléfono móvil");
        System.out.println("2. Teléfono fijo");
        System.out.println("3. Correo");
        System.out.println("4. Redes sociales");
        System.out.println("5. País");
        if (contacto instanceof Persona) {
            System.out.println("6. Nombre");
            System.out.println("7. Apellido");
            System.out.println("8. Cumpleaños");
            System.out.println("9. Ciudad");
        } else if (contacto instanceof Empresa) {
            System.out.println("6. Nombre empresa");
            System.out.println("7. RUC");
            System.out.println("8. Dirección");
            System.out.println("9. Sitio web");
        }
        System.out.print("Seleccione una opción: ");
        int opcion = Integer.parseInt(sc.nextLine());

        switch (opcion) {
            case 1 -> { System.out.print("Nuevo Teléfono móvil: "); contacto.setTelefonoMovil(sc.nextLine()); }
            case 2 -> { System.out.print("Nuevo Teléfono fijo: "); contacto.setTelefonoFijo(sc.nextLine()); }
            case 3 -> { System.out.print("Nuevo Correo: "); contacto.setCorreo(sc.nextLine()); }
            case 4 -> { System.out.print("Nuevas Redes sociales: "); contacto.setRedesSociales(sc.nextLine()); }
            case 5 -> { System.out.print("Nuevo País: "); contacto.setPais(sc.nextLine()); }
            case 6 -> {
                if (contacto instanceof Persona p) {
                    System.out.print("Nuevo Nombre: "); p.setNombre(sc.nextLine());
                } else if (contacto instanceof Empresa e) {
                    System.out.print("Nuevo Nombre empresa: "); e.setNombreEmpresa(sc.nextLine());
                }
            }
            case 7 -> {
                if (contacto instanceof Persona p) {
                    System.out.print("Nuevo Apellido: "); p.setApellido(sc.nextLine());
                } else if (contacto instanceof Empresa e) {
                    System.out.print("Nuevo RUC: "); e.setNumeroRuc(sc.nextLine());
                }
            }
            case 8 -> {
                if (contacto instanceof Persona p) {
                    System.out.print("Nuevo Cumpleaños: "); p.setCumpleaños(sc.nextLine());
                } else if (contacto instanceof Empresa e) {
                    System.out.print("Nueva Dirección: "); e.setDireccion(sc.nextLine());
                }
            }
            case 9 -> {
                if (contacto instanceof Empresa e) {
                    System.out.print("Nuevo Sitio web: "); e.setSitioWeb(sc.nextLine());
                } else if (contacto instanceof Persona p) {
                    System.out.print("Nueva Ciudad: "); p.setCiudad(sc.nextLine());
                }
            }
            default -> System.out.println("Opción inválida.");
        }
    }

    public void removerAtributos(Contacto contacto) {
        System.out.println("¿Qué desea remover?");
        System.out.println("1. Teléfono fijo");
        System.out.println("2. Redes sociales");
        System.out.println("3. Correo");
        System.out.println("4. País");
        if (contacto instanceof Persona) {
            System.out.println("5. Nombre");
            System.out.println("6. Apellido");
            System.out.println("7. Cumpleaños");
            System.out.println("8. Ciudad");
        } else if (contacto instanceof Empresa) {
            System.out.println("5. Nombre empresa");
            System.out.println("6. RUC");
            System.out.println("7. Dirección");
            System.out.println("8. Sitio web");
        }
        System.out.print("Seleccione una opción: ");
        int opcion = Integer.parseInt(sc.nextLine());

        switch (opcion) {
            case 1 -> contacto.setTelefonoFijo("");
            case 2 -> contacto.setRedesSociales("");
            case 3 -> contacto.setCorreo("");
            case 4 -> contacto.setPais("");
            case 5 -> {
                if (contacto instanceof Persona p) p.setNombre("");
                else if (contacto instanceof Empresa e) e.setNombreEmpresa("");
            }
            case 6 -> {
                if (contacto instanceof Persona p) p.setApellido("");
                else if (contacto instanceof Empresa e) e.setNumeroRuc("");
            }
            case 7 -> {
                if (contacto instanceof Persona p) p.setCumpleaños("");
                else if (contacto instanceof Empresa e) e.setDireccion("");
            }
            case 8 -> {
                if (contacto instanceof Persona p) p.setCiudad("");
                else if (contacto instanceof Empresa e) e.setSitioWeb("");
            }
            default -> System.out.println("Opción inválida.");
        }
    }

   
    public void eliminarContacto(ListaCircularContacto lista) {
        if (lista.getInicio() == null) {
            System.out.println("No hay contactos registrados.");
            return;
        }

        Nodo actual = lista.getInicio();
        int index = 1;

        System.out.println("Seleccione el contacto a eliminar:");
        do {
            System.out.println(index + ". " + actual.getDato().obtenerNombre());
            actual = actual.getSiguiente();
            index++;
        } while (actual != lista.getInicio());

        System.out.print("Ingrese el número del contacto a eliminar: ");
        int opcion;
        try {
            opcion = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Opción inválida.");
            return;
        }

        if (lista.remove(opcion - 1) == null) {
            System.out.println("No se pudo eliminar el contacto. Verifique el número ingresado.");
        } else {
            System.out.println("Contacto eliminado correctamente.");
        }
    }
 
  
    public void cargarContactos(ListaCircularContacto lista, String nombreUsuario) {
        String nombreArchivo = nombreUsuario + "_contactos.dat";
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            ListaCircularContacto cargada = (ListaCircularContacto) in.readObject();
            Nodo actual = cargada.getInicio();
            if (actual != null) {
                do {
                    lista.agregar(actual.getDato());
                    actual = actual.getSiguiente();
                } while (actual != cargada.getInicio());
            }
            System.out.println("Iniciando Sesion...");
        } catch (Exception e) {
            System.out.println();
        }
    }

    public void guardarContactos(ListaCircularContacto lista, String nombreUsuario) {
        String nombreArchivo = nombreUsuario + "_contactos.dat";
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            out.writeObject(lista);
            System.out.println("Contactos guardados exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar contactos: " + e.getMessage());
        }
    }
    
    public Contacto seleccionarContacto(ListaCircularContacto lista) {
    if (lista.getInicio() == null) {
        System.out.println("No hay contactos registrados.");
        return null;
    }

    Nodo actual = lista.getInicio();
    int index = 1;

    System.out.println("Seleccione el contacto:");
    do {
        System.out.println(index + ". " + actual.getDato().obtenerNombre());
        actual = actual.getSiguiente();
        index++;
    } while (actual != lista.getInicio());

    System.out.print("Ingrese el número del contacto: ");
    int opcion;
    try {
        opcion = Integer.parseInt(sc.nextLine());
    } catch (NumberFormatException e) {
        System.out.println("Opción inválida.");
        return null;
    }

    actual = lista.getInicio();
    for (int i = 1; i < opcion && actual.getSiguiente() != null; i++) {
        actual = actual.getSiguiente();
    }

    return actual.getDato();
}
   
     public void ordenarContactos(ListaCircularContacto lista) {
        System.out.println("¿Cómo desea ordenar los contactos?");
        System.out.println("1. Por nombre");
        System.out.println("2. Por país");
        System.out.println("3. Por nombre y país");
        System.out.println("4. Por redes sociales");
        System.out.println("5. Por cumpleaños (solo personas)");
        System.out.print("Seleccione una opción: ");
        int opcion = Integer.parseInt(sc.nextLine());

        Comparator<Contacto> comparador = switch (opcion) {
            case 1 -> ComparadoresContacto.porNombre();
            case 2 -> ComparadoresContacto.porPais();
            case 3 -> ComparadoresContacto.porNombreYPais();
            case 4 -> ComparadoresContacto.porRedesSociales();
            case 5 -> ComparadoresContacto.porCumpleanios();
            default -> {
                System.out.println("Opción inválida.");
                yield null;
            }
        };

        if (comparador != null) {
            mostrarContactosOrdenados(lista, comparador);
        }
    }

    public void mostrarContactosOrdenados(ListaCircularContacto lista, Comparator<Contacto> comparador) {
        PriorityQueue<Contacto> cola = new PriorityQueue<>(comparador);

        Nodo actual = lista.getInicio();
        if (actual == null) {
            System.out.println("No hay contactos registrados.");
            return;
        }

        do {
            cola.add(actual.getDato());
            actual = actual.getSiguiente();
        } while (actual != lista.getInicio());

        System.out.println("\n--- CONTACTOS ORDENADOS ---");
        int index = 1;
        while (!cola.isEmpty()) {
            Contacto c = cola.poll();
            System.out.println(index + ". " + c.obtenerNombre() + " | País: " + c.getPais());
            index++;
        }
    }
    
      public ListaCircularContacto findAll(ListaCircularContacto lista, Comparator<Contacto> cmp, Contacto referencia) {
        ListaCircularContacto resultado = new ListaCircularContacto();
        Nodo actual = lista.getInicio();

        if (actual == null) return resultado;

        do {
            if (cmp.compare(actual.getDato(), referencia) == 0) {
                resultado.agregar(actual.getDato());
            }
            actual = actual.getSiguiente();
        } while (actual != lista.getInicio());

        return resultado;
    }

    public void mostrarContactos(ListaCircularContacto lista) {
        Nodo actual = lista.getInicio();
        if (actual == null) {
            System.out.println("No hay contactos registrados.");
            return;
        }

        int index = 1;
        do {
            Contacto c = actual.getDato();
            System.out.println("+------------------------------+");
            System.out.println(index + ". " + c.obtenerNombre());
            System.out.println("Teléfono móvil: " + c.getTelefonoMovil());
            System.out.println("Teléfono fijo: " + c.getTelefonoFijo());
            System.out.println("Correo: " + c.getCorreo());
            System.out.println("Redes sociales: " + c.getRedesSociales());
            System.out.println("País: " + c.getPais());

            if (c instanceof Persona p) {
                System.out.println("Apellido: " + p.getApellido());
                System.out.println("Cumpleaños: " + p.getCumpleaños());
                System.out.println("Ciudad: " + p.getCiudad());
            } else if (c instanceof Empresa e) {
                System.out.println("Nombre Empresa: " + e.getNombreEmpresa());
                System.out.println("RUC: " + e.getNumeroRuc());
                System.out.println("Dirección: " + e.getDireccion());
                System.out.println("Sitio web: " + e.getSitioWeb());
            }
            index++;
            actual = actual.getSiguiente();
        } while (actual != lista.getInicio());
    }
     
    public void filtrarContactos(ListaCircularContacto lista) {
        System.out.println("Filtrar por:");
        System.out.println("1. País específico");
        System.out.println("2. Personas nacidas en un mes");
        System.out.println("3. Por nombre específico");
        System.out.print("Seleccione una opción: ");
        int opcion = Integer.parseInt(sc.nextLine());

        ListaCircularContacto filtrados = new ListaCircularContacto();

        if (opcion == 1) {
            System.out.print("Ingrese el país: ");
            String pais = sc.nextLine();
            Nodo actual = lista.getInicio();
            if (actual == null) return;
            do {
                if (actual.getDato().getPais().equalsIgnoreCase(pais)) {
                    filtrados.agregar(actual.getDato());
                }
                actual = actual.getSiguiente();
            } while (actual != lista.getInicio());

        } else if (opcion == 2) {
            System.out.print("Ingrese el mes (1-12): ");
            int mes = Integer.parseInt(sc.nextLine());
            Nodo actual = lista.getInicio();
            if (actual == null) return;
            do {
                if (actual.getDato() instanceof Persona p) {
                    try {
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        LocalDate fecha = LocalDate.parse(p.getCumpleaños(), formatter);
                        if (fecha.getMonthValue() == mes) {
                            filtrados.agregar(p);
                        }
                    } catch (Exception e) {}
                }
                actual = actual.getSiguiente();
            } while (actual != lista.getInicio());

        } else if (opcion == 3) {
            System.out.print("Ingrese el nombre exacto: ");
            String nombre = sc.nextLine().toLowerCase();
            Nodo actual = lista.getInicio();
            if (actual == null) return;
            do {
                if (actual.getDato().obtenerNombre().toLowerCase().equals(nombre)) {
                    filtrados.agregar(actual.getDato());
                }
                actual = actual.getSiguiente();
            } while (actual != lista.getInicio());

        } else {
            System.out.println("Opción inválida.");
            return;
        }

        if (filtrados.getInicio() != null) {
            System.out.println("\n--- CONTACTOS FILTRADOS ---");
            mostrarContactos(filtrados);
        } else {
            System.out.println("No se encontraron contactos con ese criterio.");
        }
    }

      public void gestionarGrupos(ListaCircularContacto lista) {
        while (true) {
            System.out.println("\n--- Gestión de Grupos ---");
            System.out.println("1. Crear nuevo grupo");
            System.out.println("2. Añadir contacto a grupo");
            System.out.println("3. Mostrar contactos de grupo");
            System.out.println("4. Eliminar contacto de grupo");
            System.out.println("5. Eliminar grupo");
            System.out.println("6. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            int op = Integer.parseInt(sc.nextLine());

            switch (op) {
                case 1 -> {
                    System.out.print("Nombre del nuevo grupo: ");
                    String nombre = sc.nextLine();
                    if (grupos.containsKey(nombre)) {
                        System.out.println("Ya existe un grupo con ese nombre.");
                    } else {
                        grupos.put(nombre, new ListaCircularContacto());
                        System.out.println("Grupo creado correctamente.");
                    }
                }
                case 2 -> {
                    System.out.print("Nombre del grupo: ");
                    String nombre = sc.nextLine();
                    ListaCircularContacto grupo = grupos.get(nombre);
                    if (grupo == null) {
                        System.out.println("El grupo no existe.");
                        break;
                    }
                    Contacto c = seleccionarContacto(lista);
                    if (c != null) {
                        grupo.agregar(c);
                        System.out.println("Contacto añadido al grupo.");
                    }
                }
                case 3 -> {
                    System.out.print("Nombre del grupo: ");
                    String nombre = sc.nextLine();
                    ListaCircularContacto grupo = grupos.get(nombre);
                    if (grupo != null) {
                        mostrarContactos(grupo);
                    } else {
                        System.out.println("Grupo no encontrado.");
                    }
                }
                case 4 -> {
                    System.out.print("Nombre del grupo: ");
                    String nombre = sc.nextLine();
                    ListaCircularContacto grupo = grupos.get(nombre);
                    if (grupo != null) {
                        Contacto c = seleccionarContacto(grupo);
                        if (grupo.eliminarPorObjeto(c)) {
                            System.out.println("Contacto eliminado del grupo.");
                        } else {
                            System.out.println("No se pudo eliminar el contacto.");
                        }
                    } else {
                        System.out.println("Grupo no encontrado.");
                    }
                }
                case 5 -> {
                    System.out.print("Nombre del grupo a eliminar: ");
                    String nombre = sc.nextLine();
                    if (grupos.remove(nombre) != null) {
                        System.out.println("Grupo eliminado exitosamente.");
                    } else {
                        System.out.println("Grupo no encontrado.");
                    }
                }
                case 6 -> {
                    return;
                }
                default -> System.out.println("Opción inválida.");
            }
        }
    }
    
      @SuppressWarnings("unchecked")
    public void cargarGrupos(String nombreUsuario) {
        String archivo = nombreUsuario + "_grupos.dat";
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(archivo))) {
            grupos = (Map<String, ListaCircularContacto>) in.readObject();
            System.out.println("...");
        } catch (Exception e) {
            System.out.println("No se encontraron grupos guardados.");
            grupos = new HashMap<>();
        }
    }

    public void guardarGrupos(String nombreUsuario) {
        String archivo = nombreUsuario + "_grupos.dat";
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(archivo))) {
            out.writeObject(grupos);
            System.out.println("Grupos guardados correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar los grupos: " + e.getMessage());
        }
    }

}

