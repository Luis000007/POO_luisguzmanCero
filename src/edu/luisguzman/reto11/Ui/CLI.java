package edu.luisguzman.reto11.Ui;

import edu.luisguzman.reto11.Idiomas.Eng;
import edu.luisguzman.reto11.Idiomas.Esp;
import edu.luisguzman.reto11.Idiomas.Idiomas;
import edu.luisguzman.reto11.Process.TopWordsFinder;

import java.util.Scanner;

/**
 * Clase que proporciona una interfaz de línea de comandos para interactuar con el proceso de identificación de palabras.
 */
public class CLI {
    private static Idiomas idiomas;

    /**
     * Método principal que inicia la interfaz de línea de comandos.
     *
     * @param args Los argumentos de la línea de comandos (no se utilizan en este caso).
     */
    public static void main(String[] args) {
        idiomas = new Esp();
        Scanner scanner = new Scanner(System.in);
        int opcionIdioma = 0;

        // Bucle para seleccionar el idioma
        while (true) {
            System.out.println(idiomas.MENU_IDENTIFICADOR);

            if (scanner.hasNextInt()) {
                opcionIdioma = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea pendiente

                if (opcionIdioma == 1 || opcionIdioma == 2) {
                    break; // Salir del bucle si la opción es válida
                } else {
                    System.out.println(idiomas.OPCION_1A2);
                }
            } else {
                System.out.println(idiomas.OPCION_INVALIDA);
                scanner.nextLine(); // Consumir la entrada inválida
            }
        }

        // Selección del idioma
        switch (opcionIdioma) {
            case 1:
               idiomas = new Esp();
                break;
            case 2:
                idiomas = new Eng();
                break;
            default:
                System.out.println(idiomas.OPCION_1A2);
                break;
        }

        // Set the language
        TopWordsFinder.setLanguege(idiomas);

        int opcionLibro = 0;

        // Bucle para seleccionar el libro y realizar el análisis de palabras
        while (opcionLibro != 6) {
            System.out.println(idiomas.MENU_LIBROS);

            if (scanner.hasNextInt()) {
                opcionLibro = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea pendiente
            } else {
                System.out.println(idiomas.OPCION_INVALIDA);
                scanner.nextLine(); // Consumir la entrada inválida
                continue;
            }

            // Selección del libro y procesamiento
            switch (opcionLibro) {
                case 1:
                    System.out.println(idiomas.EL_PRINCIPE);
                    procesarLibro("src/edu/luisguzman/reto11/Libros/El_principe_Maquiavelo.txt");
                    break;
                case 2:
                    System.out.println(idiomas.ARTE_DE_LA_GUERRA);
                    procesarLibro("src/edu/luisguzman/reto11/Libros/Arte-de-la-guerra.txt");
                    break;
                case 3:
                    System.out.println(idiomas.EL_MONJE_QUE_VENDIO_SU_FERRARI);
                    procesarLibro("src/edu/luisguzman/reto11/Libros/Robin-Sharma-El-Monje-que-Vendio-su-Ferrari.txt");
                    break;
                case 4:
                    System.out.println(idiomas.THE_WAY_OF_THE_SUPERIOR_MAN);
                    procesarLibro("src/edu/luisguzman/reto11/Libros/The-Way-Of-The-Superior-Man.txt");
                    break;
                case 5:
                    System.out.println(idiomas.PRINCIPITO);
                    procesarLibro("src/edu/luisguzman/reto11/Libros/el-principito.txt");
                    break;
                case 6:
                    System.out.println(idiomas.GRACIAS_POR_USAR);
                    System.out.println(idiomas.SALIENDO);
                    break;
                default:
                    System.out.println(idiomas.OPCION_INVALIDA);
                    break;
            }
        }

        scanner.close(); // Cerrar el Scanner al salir del bucle principal
    }

    /**
     * Método para procesar un libro utilizando la clase TopWordsFinder.
     *
     * @param fileName La ruta del archivo de texto que contiene el libro.
     */
    private static void procesarLibro(String fileName) {
        TopWordsFinder topWordsFinder = new TopWordsFinder();
        topWordsFinder.procesarLibro(fileName);
    }
}
