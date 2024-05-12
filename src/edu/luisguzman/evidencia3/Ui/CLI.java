package edu.luisguzman.evidencia3.Ui;

import edu.luisguzman.evidencia3.process.CPU;
import edu.luisguzman.evidencia3.process.Vs;

import java.io.IOException;
import java.util.Scanner;

public class CLI {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        CLI menu = new CLI();
        menu.imprimirMenuInicial(scanner);
    }

    public void imprimirMenuInicial(Scanner scanner) throws IOException {
        int opcionIdioma = 0;

        while (true) {
            System.out.println("********** Bienvenido a Gato ***********");

            System.out.println("Selecciona el idioma de tu preferencia");
            System.out.println("1. Español");
            System.out.println("2. English");
            System.out.println("Ingresa un número:");

            if (scanner.hasNextInt()) {
                opcionIdioma = scanner.nextInt();
                scanner.nextLine();

                if (opcionIdioma == 1 || opcionIdioma == 2) {
                    break;
                } else {
                    System.out.println("Opción inválida. Por favor, selecciona 1 para Español o 2 para English.");
                }
            } else {
                System.out.println("Opción inválida. Por favor, ingresa una opción válida.");
                scanner.nextLine();
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

        System.out.println("************************************** Instrucciones ****************************************");
        System.out.println("- Puedes elegir cualquier casilla que contenga un número");
        System.out.println("- Las casillas que aparezcan con 'X' u 'O' ya están ocupadas y no pueden ser seleccionadas");
        System.out.println("- El primero en hacer una línea de tres 'X' u 'O' es el ganador");
        System.out.println("¡Mucha suerte!");
        System.out.println("************************************************************************************************");

        contra(scanner);
    }

    public void contra(Scanner scanner) throws IOException {
        int opcionJuego = 0;

        while (true) {
            System.out.println("*******************************************");
            System.out.println("Elige un modo de juego");
            System.out.println("1. Jugar contra otro jugador");
            System.out.println("2. Jugar contra el CPU");
            System.out.println("3. Salir del programa");
            System.out.println("Ingresa un número:");

            if (scanner.hasNextInt()) {
                opcionJuego = scanner.nextInt();
                scanner.nextLine();

                if (opcionJuego >= 1 && opcionJuego <= 3) {

                    break;
                } else {
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                }
            } else {
                System.out.println("Opción inválida. Por favor, ingresa una opción válida.");
                scanner.nextLine();
            }
        }

        switch (opcionJuego) {
            case 1:
                System.out.println("*******************************************");
                System.out.println("Has seleccionado: Jugar contra otro jugador");
                Vs.contra(scanner);
                break;
            case 2:
                System.out.println("*******************************************");
                System.out.println("Has seleccionado: Jugar contra el CPU");
                CPU.maquina(scanner);
                break;
            case 3:
                System.out.println("Gracias por jugar :D");
                break;
        }

        // Si se selecciona la opción 3, el programa termina
        if (opcionJuego == 3) {
            System.out.println("Saliendo...");
        }
    }
}

