package edu.luisguzman.reto9.Ui;

import edu.luisguzman.reto9.Process.TopWordsFinder;

import java.util.Scanner;

public class CLI {
    private static Idiomas idiomas;
    public static void main(String[] args) {
        idiomas = new Esp();
        idiomas = new Eng();
        Scanner scanner = new Scanner(System.in);

        int opcionIdioma = 0;

        while (true) {
            System.out.println("********** BIENVENIDO AL CONTADOR DE PALABRAS :D **********");
            System.out.println("Selecciona el idioma de su preferencia");
            System.out.println("1. Español");
            System.out.println("2. English");

            if (scanner.hasNextInt()) {
                opcionIdioma = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea pendiente

                if (opcionIdioma == 1 || opcionIdioma == 2) {
                    break; // Salir del bucle si la opción es válida
                } else {
                    System.out.println("Opción inválida. Por favor, selecciona 1 para Español o 2 para English.");
                }
            } else {
                System.out.println("Opcion inválida. Por favor, ingresa una opcion valida.");
                scanner.nextLine(); // Consumir la entrada inválida
            }

            switch (opcionIdioma){
                case 1:
                    idiomas = new Esp();

                    break;
                case 2:
                    idiomas = new Eng();

                    break;
                default:
                    System.out.println("Opción inválida. Por favor, selecciona 1 para Español o 2 para English.");

                    break;

            }
        }

        TopWordsFinder.setLanguage(idiomas);

        int opcionLibro = 0;

        while (opcionLibro != 6) {
            System.out.println(idiomas.MENU);

            if (scanner.hasNextInt()) {
                opcionLibro = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea pendiente
            } else {
                System.out.println(idiomas.OPCIONNODISPONIBLE);
                scanner.nextLine(); // Consumir la entrada inválida
                continue;
            }

            switch (opcionLibro) {
                case 1:
                    System.out.println("**********************************************");
                    System.out.println(idiomas.ELPRINCIPE);
                    procesarLibro("src/edu/luisguzman/reto9/Libros/El_principe_Maquiavelo.txt");
                    break;
                case 2:
                    System.out.println("**********************************************");
                    System.out.println(idiomas.ELARTEDELAGUERRA);
                    procesarLibro("src/edu/luisguzman/reto9/Libros/Arte-de-la-guerra.txt");
                    break;
                case 3:
                    System.out.println("**********************************************");
                    System.out.println(idiomas.ELMONJEQUEVENDIOSUFERRARI);
                    procesarLibro("src/edu/luisguzman/reto9/Libros/Robin-Sharma-El-Monje-que-Vendio-su-Ferrari.txt");
                    break;
                case 4:
                    System.out.println("**********************************************");
                    System.out.println(idiomas.THEWEYOFTHESUPERIORMAN);
                    procesarLibro("src/edu/luisguzman/reto9/Libros/The-Way-Of-The-Superior-Man.txt");
                    break;
                case 5:
                    System.out.println("**********************************************");
                    System.out.println(idiomas.ELPRINCIPITO);
                    procesarLibro("src/edu/luisguzman/reto9/Libros/el-principito.txt");
                    break;
                case 6:
                    System.out.println(idiomas.GRACIAS);
                    System.out.println(idiomas.SALIENDO);
                    break;
                default:
                    System.out.println(idiomas.OPCIONNODISPONIBLE);
                    break;
            }
        }
        scanner.close(); // Cerrar el Scanner al salir del bucle principal
    }

    // Método para procesar el libro seleccionado
    private static void procesarLibro(String fileName) {
        TopWordsFinder topWordsFinder = new TopWordsFinder();
        topWordsFinder.procesarLibro(fileName);
    }
}