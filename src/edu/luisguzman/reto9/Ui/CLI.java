/**
 * La clase CLI (Interfaz de Línea de Comandos) proporciona una interfaz de usuario simple para interactuar con el programa de conteo de palabras.
 * Los usuarios pueden seleccionar el idioma en el que desean interactuar y luego elegir un libro para analizar.
 */
package edu.luisguzman.reto9.Ui;

import edu.luisguzman.reto9.Process.TopWordsFinder;

import java.util.Scanner;

public class CLI {
    private static Idiomas idiomas;

    /**
     * Método principal que inicia la aplicación de la Interfaz de Línea de Comandos (CLI).
     * @param args Argumentos de la línea de comandos (no se utilizan en esta aplicación).
     */
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
                scanner.nextLine();

                if (opcionIdioma == 1 || opcionIdioma == 2) {
                    break;
                } else {
                    System.out.println("Opción inválida. Por favor, selecciona 1 para Español o 2 para English.");
                }
            } else {
                System.out.println("Opcion inválida. Por favor, ingresa una opcion valida.");
                scanner.nextLine();
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
                scanner.nextLine();
            } else {
                System.out.println(idiomas.OPCIONNODISPONIBLE);
                scanner.nextLine();
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
        scanner.close();
    }

    /**
     * Método para procesar el libro seleccionado y realizar el análisis de palabras.
     * @param fileName El nombre del archivo del libro que se va a procesar.
     */
    private static void procesarLibro(String fileName) {
        TopWordsFinder topWordsFinder = new TopWordsFinder();
        topWordsFinder.procesarLibro(fileName);
    }
}
