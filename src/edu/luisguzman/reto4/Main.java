package edu.luisguzman.reto4;

import edu.luisguzman.reto4.ui.CLI;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CLI cli = new CLI();
        Scanner scanner = new Scanner(System.in);
        char opcion;

        do {
            mostrarMenu();
            opcion = scanner.next().charAt(0);
            scanner.nextLine(); // Consume la nueva línea pendiente después de next()

            switch (opcion) {
                case 'A':
                    cli.realizarVenta();
                    break;
                case 'B':
                    cli.mostrarDatos();
                    break;
                case 'S':
                    System.out.println("Programa finalizado.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
            }
        } while (opcion != 'S');
    }

    public static void mostrarMenu() {
        System.out.println("---- Menú ----");
        System.out.println("A. Realizar venta de boleto");
        System.out.println("B. Mostrar datos de la lista de ventas");
        System.out.println("S. Finalizar programa");
        System.out.print("Ingrese la opción a ejecutar: ");
    }
}
