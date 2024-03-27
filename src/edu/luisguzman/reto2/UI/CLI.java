package edu.luisguzman.reto2.UI;

import edu.luisguzman.reto2.process.Usuario;

import java.util.Scanner;

public class CLI {

    public static void main(String[] args) {

        Usuario usuario = new Usuario();

        boolean credencialesCorrectas = false;
        Scanner scanner = new Scanner(System.in);

        while (!credencialesCorrectas) {
            System.out.print("Ingresa tu usuario: ");
            String usuarioEscrito = scanner.nextLine();

            System.out.print("Ingresa tu contraseña: ");
            String contraseñaEscrita = scanner.nextLine();

            if (usuario.autenticar(usuarioEscrito, contraseñaEscrita)) {
                System.out.println("¡Bienvenido!");
                credencialesCorrectas = true;
            } else {
                System.out.println("Usuario o contraseña incorrectos. Intenta nuevamente.");
            }
        }

        mostrarMenu();
        int opcion = obtenerOpcion();
        procesarOpcion(opcion);

        scanner.close();
    }

    public static void mostrarMenu() {
        System.out.println("++++++++++++++++++++++");
        System.out.println("¿Qué desea hacer hoy?");
        System.out.println("1. Vender cajas");
        System.out.println("2. Comprar cajas");
        System.out.println("3. Mostrar reporte");
        System.out.println("4. Salir del programa");
        System.out.println("++++++++++++++++++++++++");
    }

    public static int obtenerOpcion() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el número de la opción deseada: ");
        return scanner.nextInt();
    }

    public static void procesarOpcion(int opcion) {
        Scanner scanner = new Scanner(System.in);
        Usuario usuario = new Usuario();
        switch (opcion) {
            case 1:
                System.out.println("Seleccionaste vender cajas.");
                // Aquí puedes agregar la lógica para vender cajas
                break;
            case 2:
                System.out.println("Seleccionaste comprar cajas.");
                // Aquí puedes agregar la lógica para comprar cajas
                break;
            case 3:
                System.out.println("Seleccionaste mostrar reporte.");
                // Aquí puedes agregar la lógica para mostrar reporte
                break;
            case 4:
                System.out.println("Saliendo del programa. ¡Hasta luego!");
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }
}
