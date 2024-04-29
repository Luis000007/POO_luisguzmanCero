package edu.luisguzman.evidencia3.Ui;

import edu.luisguzman.evidencia3.process.Vs;

import java.io.IOException;
import java.util.Scanner;

public class CLI {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int opcionIdioma = 0;

        while (true) {
            System.out.println("********** Bienvenido a Gato ***********");
            System.out.println("Selecciona el idioma de su preferencia");
            System.out.println("1. Español");
            System.out.println("2. English");
            System.out.println("Ingresa un numero:");

            if (scanner.hasNextInt()) {
                opcionIdioma = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea pendiente

                if (opcionIdioma == 1 || opcionIdioma == 2) {
                    break; // Salir del bucle si la opción es válida
                } else {
                    System.out.println("Opción inválida. Por favor, selecciona 1 para Español o 2 para English.");
                }
            } else {
                System.out.println("Opción inválida. Por favor, ingresa una opción válida.");
                scanner.nextLine(); // Consumir la entrada inválida
            }
        }

        switch (opcionIdioma) {
            case 1:
                System.out.println("Has seleccionado: Español");
                break;
            case 2:
                System.out.println("You have selected: English");
                break;
        }

        int opcionjuego = 0;

        while (true) {
            System.out.println("*****************************");
            System.out.println("Elige un modo de juego");
            System.out.println("1. Jugar contra otro jugador");
            System.out.println("2. Jugar contra el CPU");
            System.out.println("Ingresa un numero:");

            if (scanner.hasNextInt()) {
                opcionjuego = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea pendiente

                if (opcionjuego == 1 || opcionjuego == 2) {
                    // Salir del bucle si la opción es válida
                    break;
                } else {
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                }
            } else {
                System.out.println("Opción inválida. Por favor, ingresa una opción válida.");
                scanner.nextLine(); // Consumir la entrada inválida
            }
        }

        switch (opcionjuego) {
            case 1:
                System.out.println("*******************************************");
                System.out.println("Has seleccionado: Jugar contra otro jugador");
                Vs.contra(scanner);
                break;

            case 2:
                System.out.println("*******************************************");
                System.out.println("Has seleccionado: Jugar contra el CPU");

                break;
        }
    }
}