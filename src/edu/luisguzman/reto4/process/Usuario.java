package edu.luisguzman.reto4.process;

import java.util.Scanner;

public class Usuario {
    private static final Scanner scanner = new Scanner(System.in);

    public static String solicitarNombreCompleto() {
        System.out.print("Ingrese el nombre completo del comprador: ");
        return scanner.nextLine();
    }

    public static int solicitarCantidadBoletos() {
        System.out.print("Ingrese la cantidad de boletos a comprar: ");
        return scanner.nextInt();
    }

    public static String solicitarNombrePasajero() {
        System.out.print("Ingrese el nombre completo del pasajero adicional: ");
        scanner.nextLine(); // Consume la nueva línea pendiente después de nextInt()
        return scanner.nextLine();
    }
}
