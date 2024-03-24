package edu.luisguzman.reto7_2.ui;

import edu.luisguzman.reto7_2.process.*;

import java.util.Scanner;

/**
 * Esta clase representa la interfaz de línea de comandos (CLI) para interactuar con las operaciones matemáticas.
 */
public class CLI {

    private static Idiomas idiomas;

    private static final Scanner sc = new Scanner(System.in);

    /**
     * Punto de entrada principal del programa.
     * Configura el idioma y lanza la aplicación.
     *
     * @param args Los argumentos de la línea de comandos (no utilizados en este caso).
     */
    public static void main(String[] args) {
        idiomas = new Esp(); // Por defecto en español
        launchApp();
    }

    /**
     * Muestra el menú para seleccionar el idioma.
     * Configura el idioma seleccionado en toda la aplicación.
     */
    public static void showMenuIdiomas() {
        System.out.println("Seleccione el idioma de su preferencia");
        System.out.println("1. Español");
        System.out.println("2. English");
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                idiomas = new Esp();
                break;
            case 2:
                idiomas = new Eng();
                break;
            default:
                System.out.println("Opcion no disponible");
        }

        // Configura el idioma en las clases de procesamiento
        Multiplicacion.setLanguage(idiomas);
        Resta.setLanguage(idiomas);
        Potencia.setLanguage(idiomas);
        Raiz.setLanguage(idiomas);
        Suma.setLanguage(idiomas);
        Modulo.setLanguage(idiomas);
        Logaritmo.setLanguage(idiomas);
        Division.setLanguage(idiomas);
    }

    /**
     * Lanza la aplicación y maneja las operaciones matemáticas seleccionadas por el usuario.
     */
    public static void launchApp() {
        int opcion;
        boolean continuar = true;
        showMenuIdiomas();

        Scanner scanner = new Scanner(System.in);

        while (continuar) {
            System.out.println(idiomas.MENU);

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println(idiomas.SELECCION_SUMA);
                    Suma.suma(scanner);
                    break;

                case 2:
                    System.out.println(idiomas.SELECCION_RESTA);
                    Resta.resta(scanner);
                    break;

                case 3:
                    System.out.println(idiomas.SELECCION_MULTIPLICACION);
                    Multiplicacion.multiplicar(scanner);
                    break;

                case 4:
                    System.out.println(idiomas.SELECCION_DIVISION);
                    Division.dividir(scanner);
                    break;

                case 5:
                    System.out.println(idiomas.SELECCION_MODULO);
                    Modulo.modulo(scanner);
                    break;

                case 6:
                    System.out.println(idiomas.SELECCION_POTENCIA);
                    Potencia.potencia(scanner);
                    break;

                case 7:
                    System.out.println(idiomas.SELECCION_RAIZ);
                    Raiz.raizCuadrada(scanner);
                    break;

                case 8:
                    System.out.println(idiomas.SELECCION_LOGARITMO);
                    Logaritmo.logaritmo(scanner);
                    break;

                case 9:
                    System.out.println(idiomas.SELECCION_SALIR);
                    continuar = false;
                    break;

                default:
                    System.out.println(idiomas.DEFAULT);
                    break;
            }

            if (!continuar) {
                break;
            }

            System.out.print(idiomas.OTRA_OPERACION);
            String respuesta = scanner.next();
            continuar = respuesta.equalsIgnoreCase(idiomas.SI);
        }

        System.out.print(idiomas.Despedida);
    }
}
